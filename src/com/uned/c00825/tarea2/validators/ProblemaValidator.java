/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.validators;

import br.com.fluentvalidator.AbstractValidator;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.uned.c00825.tarea2.entities.Problema;

/**
 * Validator for the Problema entity.
 * Utiliza la librería FluentValidator para validar campos como la descripción
 * y otras reglas de negocio.
 */
public class ProblemaValidator extends AbstractValidator<Problema> {

    @Override
    public void rules() {

        // Validar que la descripción no sea nula ni vacía
        ruleFor(Problema::getDescription) 
            .must(not(stringEmptyOrNull()))
            .withMessage("La descripción del problema es requerida.")
            .withFieldName("description");
        
            }
}