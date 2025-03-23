/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.validators;


import br.com.fluentvalidator.context.ValidationResult;
import br.com.fluentvalidator.exception.ValidationException;

/**
 * Excepción personalizada para la validación de entidades.
 * Se lanza cuando la validación de una entidad falla.
 * 
 * @author byron
 */
public class EntityValidationException extends ValidationException {

    /**
     * Constructor que recibe el resultado de la validación.
     *
     * @param validationResult Resultado de la validación que contiene los errores.
     */
    public EntityValidationException(final ValidationResult validationResult) {
        super(validationResult);
    }
}
