/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.da;

import com.uned.c00825.tarea2.entities.BaseEntity;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.function.Predicate;

/**
 * Clase abstracta que simula un objeto de acceso a datos (DAO) para entidades.
 * Proporciona operaciones básicas como agregar, obtener, actualizar, eliminar y
 * buscar entidades en una estructura de datos interna.
 *
 * @param <T> Tipo de entidad que extiende de BaseEntity.
 */
public abstract class DataAccessObject<T extends BaseEntity> {

    /**
     * Arreglo que funciona como estructura de almacenamiento (pila o cola).
     */
    protected T[] elements;
    protected Class<T> clazz;

    /**
     * Constructor que inicializa la estructura con una capacidad inicial.
     *
     * @param clazz Clase de la entidad.
     * @param initialCapacity Capacidad inicial de la estructura.
     */
    public DataAccessObject(Class<T> clazz, int initialCapacity) {
        this.clazz = clazz;
        elements = (T[]) Array.newInstance(clazz, initialCapacity);
        // loadDummyData();
    }

    /**
     * Agrega un valor a la estructura (pila o cola).
     *
     * @param value Entidad a agregar.
     */
    public abstract void add(T value);

    /**
     * Obtiene y elimina el valor correspondiente según la estructura (pila o cola).
     *
     * @return La entidad obtenida.
     */
    public abstract T get();

    /**
     * Busca y retorna una entidad según su identificador.
     *
     * @param id El identificador de la entidad.
     * @return La entidad encontrada o null si no existe.
     */
    public T getById(int id) {
        try {
            return Arrays.stream(elements)
                    .filter(entity -> entity != null && entity.getId() == id)
                    .findFirst()
                    .get();
        } catch (NoSuchElementException ex) {
            // No se encontró la entidad; se retorna null.
        }
        return null;
    }

    /**
     * Retorna un iterador para recorrer todas las entidades almacenadas.
     *
     * @return Iterador de entidades.
     */
    public Iterator<T> getAll() {
        return Arrays.stream(elements)
                .filter(entity -> entity != null && entity.getId() > 0)
                .iterator();
    }

    /**
     * Método para cargar datos de prueba (dummy). Puede ser sobrescrito.
     */
    protected void loadDummyData() {
    }

    /**
     * Método abstracto para obtener el identificador de una entidad.
     *
     * @return Identificador de la entidad.
     */
    protected abstract int getId();

    /**
     * Crea un nuevo arreglo con la capacidad especificada.
     *
     * @param capacity Capacidad del nuevo arreglo.
     * @return Nuevo arreglo.
     */
    protected T[] createNewArray(int capacity) {
        return (T[]) Array.newInstance(clazz, capacity);
    }

    /**
     * Retorna un iterador para recorrer las entidades que cumplen con un predicado.
     *
     * @param predicate Condición para filtrar las entidades.
     * @return Iterador de entidades que cumplen con el predicado.
     */
    public Iterator<T> getAll(Predicate<T> predicate) {
        return Arrays.stream(elements)
                .filter(predicate)
                .iterator();
    }

    /**
     * Retira y retorna el elemento que está al frente de la cola (dequeue).
     *
     * @return Elemento al frente de la cola.
     */
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T value = elements[0];
        elements = Arrays.copyOfRange(elements, 1, elements.length);
        return value;
    }

    /**
     * Verifica si la estructura está vacía.
     *
     * @return true si está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return elements == null || elements.length == 0;
    }

    /**
     * Verifica si la estructura está llena (ocupó toda la capacidad actual).
     *
     * @return true si está llena, false en caso contrario.
     */
    public boolean isFull() {
        return elements == null || elements.length == 0 || elements[elements.length - 1] != null;
    }

    /**
     * Duplica el tamaño del arreglo interno a un nuevo tamaño especificado.
     * Se copian los elementos en el nuevo arreglo.
     *
     * @param newSize Nuevo tamaño del arreglo.
     */
    protected void resize(int newSize) {
        elements = Arrays.copyOf(elements, newSize);
    }

    /**
     * Retira y retorna el primer elemento de la estructura.
     *
     * @return Primer elemento de la estructura.
     */
    protected T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T value = elements[0];
        elements = Arrays.copyOfRange(elements, 1, elements.length);
        return value;
    }
}
