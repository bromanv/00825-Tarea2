/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.entities;

/**
 *
 * @author byron
/**
 * Clase base abstracta para todas las entidades del sistema.
 * Proporciona el atributo fecha, que se asigna automáticamente al registrar la entidad.
 * 
 * @author byron
 */
public abstract class BaseEntity implements Cloneable {
    protected  int id;
    
    /**
     * Método abstracto que debe retornar el identificador único de la entidad.
     *
     * @return El identificador de la entidad.
     */    
    public  int getId(){
        return id;
    }
    public  void setId(int value){
        id = value;
    }
}

