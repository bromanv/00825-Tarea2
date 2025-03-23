/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.validators;


import br.com.fluentvalidator.AbstractValidator;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.uned.c00825.tarea2.entities.Incidente;
import java.time.LocalDate;

public class IncidenteValidator extends AbstractValidator<Incidente> {

    @Override
    public void rules() {

        // Validar que exista un usuario solicitante
        ruleFor(Incidente::getRequester)
            .must(not(stringEmptyOrNull()).and(s-> s.trim().length() != 0))
            .withMessage("El usuario solicitante es requerido.")
            .withFieldName("requester");

        // Validar la categoría (no vacía)
        ruleFor(Incidente::getCategory)
            .must(not(stringEmptyOrNull()).and(s-> s.trim().length() != 0))
            .withMessage("La categoría es requerida.")
            .withFieldName("category");
        // Validar la categoría (no vacía)
        
        // Validar el detalle (no vacío)
        ruleFor(Incidente::getDetails)
            .must(not(stringEmptyOrNull()).and(s-> s.trim().length() != 0))
            .withMessage("El detalle del incidente es requerido.")
            .withFieldName("detail");

        // Validar que la fecha no sea nula y que no sea futura, por ejemplo
        ruleFor(Incidente::getDate)
            .must(fecha -> fecha != null && !fecha.isAfter(LocalDate.now()))
            .withMessage("La fecha no puede ser nula ni una fecha futura.")
            .withFieldName("date");
    }
}
