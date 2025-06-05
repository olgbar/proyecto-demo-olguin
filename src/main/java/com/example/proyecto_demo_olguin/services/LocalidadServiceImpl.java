package com.example.proyecto_demo_olguin.services;

import com.example.proyecto_demo_olguin.entities.Localidad;
import com.example.proyecto_demo_olguin.repositories.BaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository) {
        super(baseRepository);
    }
}
