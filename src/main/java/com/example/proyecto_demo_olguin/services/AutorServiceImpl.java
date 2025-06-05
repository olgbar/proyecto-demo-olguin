package com.example.proyecto_demo_olguin.services;

import com.example.proyecto_demo_olguin.entities.Autor;
import com.example.proyecto_demo_olguin.repositories.AutorRepository;
import com.example.proyecto_demo_olguin.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor, Long> implements AutorService{

    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }
}
