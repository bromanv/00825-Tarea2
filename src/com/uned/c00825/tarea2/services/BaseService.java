/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.services;

import com.uned.c00825.tarea2.da.DataAccessObject;
import com.uned.c00825.tarea2.entities.BaseEntity;
import com.uned.c00825.tarea2.validators.EntityValidationException;
import br.com.fluentvalidator.Validator;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Clase base para manejar operaciones comunes de servicios.
 */
public abstract class BaseService<T extends BaseEntity> {
    
    protected DataAccessObject<T> dao;
    protected Validator<T> validator;
    
    /**
     * Constructor que inyecta el DAO y el validador.
     * 
     * @param dao Implementación de acceso a datos para la entidad.
     * @param validator Validador para la entidad.
     */
    public BaseService(DataAccessObject<T> dao, Validator<T> validator) {
        this.dao = dao;
        this.validator = validator;
    }
    
    /**
     * Registra una nueva entidad tras validarla.
     * 
     * @param entity La entidad a registrar.
     */
    public void register(T entity) {
        validator.validate(entity).isInvalidThrow(EntityValidationException.class);        
        dao.add(entity);
    }

    /**
     * Obtiene una entidad de la estructura de datos.
     * 
     * @return Entidad obtenida.
     */
    public T get() {
        return this.dao.get();
    }

    /**
     * Obtiene una entidad por su ID.
     * 
     * @param id ID de la entidad a obtener.
     * @return Entidad correspondiente al ID.
     */
    public T getById(int id) {
        return this.dao.getById(id);
    }

    /**
     * Obtiene todas las entidades.
     * 
     * @return Iterador con todas las entidades.
     */
    public Iterator<T> getAll() {
        return dao.getAll();
    }

    /**
     * Obtiene todas las entidades que cumplen con un predicado.
     * 
     * @param predicate Condición para filtrar las entidades.
     * @return Iterador con las entidades que cumplen el predicado.
     */
    public Iterator<T> getAll(Predicate<T> predicate) {
        return dao.getAll(predicate);
    }
}
