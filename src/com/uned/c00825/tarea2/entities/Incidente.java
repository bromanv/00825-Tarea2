/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.entities;
import java.time.LocalDate;
import java.util.Objects;
/**
 *
 * @author byron
  * Entidad que representa un "Incidente" asociado a un Problema.
 * Cada Incidente tiene un ID, usuario solicitante, categoría, detalle y fecha.
 */
public class Incidente extends BaseEntity implements Cloneable {

    // Atributo de clase para generar IDs consecutivos
    

    // Campos del enunciado
    /**
     * Usuario que reporta o solicita el incidente.
     */
    private String requester;
    /**
     * Tipo o categoría del incidente (Software, Seguridad, Redes, etc.).
     */
    private String category;
    /**
     * Descripción del incidente.
     */
    private String details;
    /**
     * Fecha en que se registra el incidente.
     */
    private LocalDate date;

    // -- CONSTRUCTORES --

    /**
     * Constructor sin parámetros.
     */
    public Incidente() {
        this.requester = "";
        this.category = "";
        this.details = "";
        this.date = LocalDate.now();
    }

    /**
     * Constructor con parámetros.
     * @param requester Usuario que reporta o solicita el incidente.
     * @param category Tipo o categoría del incidente.
     * @param details Descripción del incidente.
     * @param date Fecha en que se registra el incidente.
     */
    public Incidente(String requester, String category, String details, LocalDate date) {
       this();
        this.requester = requester;
        this.category = category;
        this.details = details;
        this.date = date;
    }

    // -- GETTERS y SETTERS --

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Incidente)) return false;
        Incidente other = (Incidente) obj;
        return this.id == other.id;
    }

    // -- Método toString() para depurar --
    @Override
    public String toString() {
        return String.format("Incidente [id=%d, requester=%s, category=%s, details=%s, date=%s]",
                this.id, this.requester, this.category, this.details, this.date);
    }
}