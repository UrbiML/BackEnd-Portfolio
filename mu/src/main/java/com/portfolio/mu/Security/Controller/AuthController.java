package com.portfolio.mu.Security.Controller;

import com.portfolio.mu.Security.Dto.JwtDto;
import com.portfolio.mu.Security.Dto.LoginUsuario;
import com.portfolio.mu.Security.Dto.NuevoUsuario;
import com.portfolio.mu.Security.Entity.Rol;
import com.portfolio.mu.Security.Entity.Usuario;
import com.portfolio.mu.Security.Enums.RolNombre;
import com.portfolio.mu.Security.Service.RolService;
import com.portfolio.mu.Security.Service.UsuarioService;
import com.portfolio.mu.Security.Controller.Mensaje;
import com.portfolio.mu.Security.jwt.JwtProvider;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "https://localhost:4200")
//@CrossOrigin(origins = "https://portfolio-f109e.web.app")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<Object>(new Mensaje("Campos mal puestos o email invalido"),HttpStatus.BAD_REQUEST);
        
        if(usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
			ResponseEntity<?> responseEntity = new ResponseEntity<Object>(new Mensaje("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
        
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
			ResponseEntity<?> responseEntity = new ResponseEntity<Object>(new Mensaje("Ese email ya existe"), HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
            nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity<Object>(new Mensaje("Usuario guardado"),HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<Object>(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        JwtDto jwtDto = new JwtDto(jwt);
        
        return new ResponseEntity<Object>(jwtDto, HttpStatus.OK);
    }
    
    
    @PostMapping("/refresh")
    public ResponseEntity<JwtDto> refresh(@RequestBody JwtDto jwtDto) throws ParseException{
    	String token = jwtProvider.refreshToken(jwtDto);
    	JwtDto jwt = new JwtDto(token);
    	return new ResponseEntity(jwt, HttpStatus.OK);
    }
    
    
}	
