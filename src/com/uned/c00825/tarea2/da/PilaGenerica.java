/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.da;

import com.uned.c00825.tarea2.entities.BaseEntity;
import java.lang.reflect.Array;

/**
 * Clase abstracta para manejar una pila genérica.
 * 
 * @param <T> Tipo de elemento que extiende BaseEntity.
 */
public abstract class PilaGenerica<T extends BaseEntity> extends DataAccessObject<T> {

    @SuppressWarnings("unchecked")
    public PilaGenerica(Class<T> clazz) {
        super(clazz, 0);
    }

    /**
     * Inserta un nuevo elemento en la parte superior de la pila (push).
     * Si la pila está llena, se duplica la capacidad.
     * 
     * @param value Elemento a insertar en la pila.
     */
    public void push(T value) {
        if (isFull()) {
            resize(elements.length + 1);
        }
        value.setId(getId());
        elements[0] = value;
    }

    @Override
    protected void resize(int newSize) {
        T[] tmp = (T[]) Array.newInstance(clazz, elements.length + 1);
        if (elements.length > 0) {
            System.arraycopy(elements, 0, tmp, 1, elements.length);
        }
        elements = tmp;
    }

    /**
     * Retira y retorna el elemento que está en la parte superior de la pila (pop).
     * 
     * @return Elemento retirado de la pila.
     */
    public T pop() {
        return removeFirst();
    }

    /**
     * Retorna el elemento en la parte superior de la pila sin removerlo.
     * 
     * @return Elemento en la cima de la pila.
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty.");
        }
        return elements[0];
    }

    /**
     * Retorna la cantidad de elementos en la pila.
     * 
     * @return Número de elementos en la pila.
     */
    public int size() {
        return elements.length;
    }

    @Override
    public void add(T value) {
        push(value);
    }

    @Override
    public T get() {
        return pop();
    }
}
