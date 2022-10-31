package com.portfolio.mu.Service;

import com.portfolio.mu.Entity.Experiencia;
import com.portfolio.mu.Dao.IExperienciaDao;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaServices {
     @Autowired
     IExperienciaDao Iexperiencia;
     
     public List<Experiencia> list(){
         return Iexperiencia.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return Iexperiencia.findById(id);
     }
     
     public Optional<Experiencia> getByNombreE(String nombreE){
         return Iexperiencia.findByNombreE(nombreE);
     }
     
     public void save(Experiencia expe){
         Iexperiencia.save(expe);
     }
     
     public void delete(int id){
         Iexperiencia.deleteById(id);
     }
     
     public boolean existsById(int id){
         return Iexperiencia.existsById(id);
     }
     
     public boolean existsByNombreE(String nombreE){
         return Iexperiencia.existsByNombreE(nombreE);
     }
}
