package com.example.proyecto_demo_olguin.services;

import com.example.proyecto_demo_olguin.entities.Base;
import com.example.proyecto_demo_olguin.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, ID extends Serializable> implements BaseService<E, ID> {
    protected BaseRepository <E, ID> baseRepository; //para que cuando se hereden los metodos, esta variable sea accesible (no private)


    public BaseServiceImpl(BaseRepository<E, ID> baseRepository) { //alt+insert para agregar constructor de la clase
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional //significa que va a hacer transacciones con la base de datos
    public List<E> findAll() throws Exception {
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage()); //esta va a ser capturada dentro del controlador
        }
    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception {
        try{
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        } catch (Exception e){
            throw new Exception(e.getMessage()); //esta va a ser capturada dentro del controlador
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id); //obtiene una entidad si la encuentra
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = baseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = baseRepository.save(entity);
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage()); //si no obtenemos una persona
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if (baseRepository.existsById(id)){
                baseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}


