/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.entities;

import com.uned.c00825.tarea2.da.PilaIncidente;

/**
 *
 * @author byron
 * Entidad que representa un "Problema" con un ID único y una descripción breve.
 * Cada Problema puede contener un arreglo de Incidentes (manejado como Pila).
 */
public class Problema extends BaseEntity implements Cloneable {

    // Atributo de clase para generar IDs consecutivos
    private static int NEXT_ID = 1;

    // Campos requeridos por el enunciado
    /**
     * Breve descripción del problema.
     */
    private String description;
    /**
     * Pila de incidentes asociados al problema.
     */
    private PilaIncidente incidents;
    
    /**
     * Índice que apunta al tope de la pila.
     * Si es -1, la pila está vacía.
     */
    private int tope;

    // -- CONSTRUCTORES --

    /**
     * Constructor sin parámetros (por defecto).
     */
    public Problema() {
        this.id = NEXT_ID++;
        this.description = "";
        this.incidents = new PilaIncidente();
        
        this.tope = -1;
    }

    /**
     * Constructor con descripción.
     * @param description Breve descripción del problema.
     */
    public Problema(String description) {
        this();        
        this.description = description;        
        
    }

    // -- GETTERS y SETTERS --

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public PilaIncidente getIncidents() {
        return incidents;
    }
   
    // -- MÉTODO PARA CLONAR (Opcional, si lo necesitas en validaciones) --

    @Override
    public Problema clone() throws CloneNotSupportedException {
        Problema clone = (Problema) super.clone();
        // Clonar el arreglo de incidentes para no afectar el original   
        return clone;
    }

    // -- Método toString() para depurar --
    @Override
    public String toString() {
        return String.format("Problema [id=%d, description=%s, stackTop=%d]", 
                this.id, this.description, this.tope);
    }
}