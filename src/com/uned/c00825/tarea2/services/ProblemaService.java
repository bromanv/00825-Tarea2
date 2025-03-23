/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.services;

import com.uned.c00825.tarea2.da.ColaProblema;
import com.uned.c00825.tarea2.entities.Incidente;
import com.uned.c00825.tarea2.entities.Problema;
import com.uned.c00825.tarea2.validators.EntityValidationException;
import com.uned.c00825.tarea2.validators.IncidenteValidator;
import com.uned.c00825.tarea2.validators.ProblemaValidator;

/**
 * Servicio para manejar la lógica de negocio de Problema.
 */
public class ProblemaService extends BaseService<Problema> {
    
    protected IncidenteValidator incidentValidator;
    
    /**
     * Constructor que inyecta el DAO y los validadores.
     * 
     * @param dao         Implementación de acceso a datos para Problema.
     * @param validator   Validador para Problema.
     * @param incidentValidator Validador para Incident.
     */    
    public ProblemaService(ColaProblema dao, ProblemaValidator validator, IncidenteValidator incidentValidator) {
        super(dao, validator);
        this.incidentValidator = incidentValidator;
    }
   
    /**
     * Valida un incidente utilizando el validador correspondiente.
     * 
     * @param item Incidente a validar.
     */
    public void validateIncident(Incidente item) {
        incidentValidator.validate(item).isInvalidThrow(EntityValidationException.class);   
    }

    /**
     * Retorna el problema que está al frente de la cola sin removerlo.
     * 
     * @return Problema al frente de la cola.
     */
    public Problema front() {
        return ((ColaProblema) dao).front();
    }

    /**
     * Retira y retorna el problema que está al frente de la cola.
     * 
     * @return Problema retirado de la cola.
     */
    public Problema dequeue() {
        return ((ColaProblema) dao).dequeue();
    }
}
