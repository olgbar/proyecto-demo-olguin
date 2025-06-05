package com.example.proyecto_demo_olguin.repositories;

import com.example.proyecto_demo_olguin.entities.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean //para que no se instancie
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID>{

}
