/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.da;

import com.uned.c00825.tarea2.entities.BaseEntity;

/**
 *
 * @author byron
 * @param <T>
 */
public abstract class ColaGenerica<T extends BaseEntity> extends DataAccessObject<T> {

 

    @SuppressWarnings("unchecked")
    public ColaGenerica(Class<T> clazz) {
        super(clazz, 0);
    }

    /**
     * Inserta un nuevo elemento al final de la cola (enqueue). Si la cola está
     * llena, se duplica la capacidad.
     *
     * @param value Elemento a insertar en la cola.
     */
    public void enqueue(T value) {
        if (isFull()) {
            resize(elements.length + 1);
        }
        value.setId(getId());
        elements[elements.length - 1] = value;
    }

    /**
     * Retira y retorna el elemento que está al frente de la cola (dequeue).
     *
     * @return Elemento al frente de la cola.
     */
    public T dequeue() {
        return removeFirst();
    }

    /**
     * Retorna el elemento del frente sin removerlo.
     *
     * @return Elemento al frente de la cola.
     */
    public T front() {
        if (isEmpty()) {
            return null;
        }
        return elements[0];
    }
    /**
     * Retorna la cantidad de elementos en la cola.
     *
     * @return Número de elementos en la cola.
     */
    public int size() {
        return elements.length;
    }    

    @Override
    public void add(T value) {
        enqueue(value);
    }

    @Override
    public T get() {
        return dequeue();
    }
    
    @Override
    protected abstract int getId();
}
