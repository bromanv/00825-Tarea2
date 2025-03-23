/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.controllers;

import com.uned.c00825.tarea2.entities.BaseEntity;
import com.uned.c00825.tarea2.services.BaseService;
import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Controlador genérico que provee operaciones CRUD comunes para cualquier entidad
 * que extienda de BaseEntity.
 *
 * @param <T> Tipo de entidad que extiende de BaseEntity.
 */
public class BaseController<T extends BaseEntity> {
    
    protected BaseService<T> service;
    
    /**
     * Constructor que inyecta el servicio genérico.
     *
     * @param service La instancia de BaseService que maneja la entidad.
     */
    public BaseController(BaseService<T> service) {
        this.service = service;
    }
    
    /**
     * Registra una nueva entidad.
     *
     * @param entity La entidad a registrar.
     */
    public void register(T entity) {
        service.register(entity);
    }
    
    /**
     * Obtiene una entidad por su identificador.
     *
     * @param id El ID de la entidad.
     * @return La entidad encontrada o null si no existe.
     */
    public T getById(int id) {
        return service.getById(id);
    }
    
    /**
     * Obtiene todas las entidades.
     *
     * @return Iterador con todas las entidades.
     */
    public Iterator<T> getAll() {
        return service.getAll();
    }

    /**
     * Obtiene todas las entidades que cumplen con un predicado.
     *
     * @param predicate Condición que deben cumplir las entidades.
     * @return Iterador con las entidades que cumplen el predicado.
     */
    public Iterator<T> getAll(Predicate<T> predicate) {
        return service.getAll(predicate);
    }
}
