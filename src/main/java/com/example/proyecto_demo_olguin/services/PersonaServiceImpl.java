package com.example.proyecto_demo_olguin.services;

import com.example.proyecto_demo_olguin.entities.Persona;
import com.example.proyecto_demo_olguin.repositories.BaseRepository;
import com.example.proyecto_demo_olguin.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Long> implements PersonaService{

    @Autowired //-> con la annotation se va a poder acceder a los metodos de la interfaz PersonaRepository
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
//            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
//            List<Persona> personas = personaRepository.search(filtro); //implementa el metodo query jpql
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
//            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
//            Page<Persona> personas = personaRepository.search(filtro, pageable); //implementa el metodo query jpql
            Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
