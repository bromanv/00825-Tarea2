/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.controllers;

import com.uned.c00825.tarea2.entities.Incidente;
import com.uned.c00825.tarea2.entities.Problema;
import com.uned.c00825.tarea2.services.ProblemaService;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador específico para la entidad Problem. Extiende BaseController para
 * las operaciones CRUD generales y agrega métodos específicos como validación
 * de incidentes y manejo de una cola de problemas.
 */

public class ProblemaController extends BaseController<Problema> {

    /**
     * Referencia específica a {@code ProblemService}, que provee la lógica de
     * negocio y métodos propios de la gestión de problemas.
     */
    private final ProblemaService problemService;

    /**
     * Construye un nuevo {@code ProblemaController}, inyectando el servicio
     * especializado en problemas.
     *
     * @param problemService Instancia de {@link ProblemService} que agrupa la
     * funcionalidad y la lógica de negocio para manipular entidades de tipo
     * {@code Problem}.
     */
    public ProblemaController(ProblemaService problemService) {
        super(problemService);
        this.problemService = problemService;
    }

    /**
     * Provee las etiquetas de columnas que se utilizan en un
     * {@link javax.swing.JTable} para visualizar los datos de los problemas.
     *
     * @return Un arreglo de {@code String} con los nombres de cada columna.
     */
    public String[] getTableModelColumns() {
        return new String[]{
            "ID",
            "Descripción"
        };
    }

    /**
     * Carga en un {@link DefaultTableModel} todos los registros de problemas
     * actuales, mapeando cada uno de sus campos a las columnas del modelo.
     *
     * @param tableModel Modelo de tabla donde se insertarán los datos
     * correspondientes a los problemas.
     */
    public void loadTableModel(DefaultTableModel tableModel) {
        tableModel.setRowCount(0);  // Limpia la tabla antes de agregar datos
        Iterator<Problema> problems = getAll();
        while (problems.hasNext()) {
            Problema problem = problems.next();
            tableModel.addRow(new Object[]{
                problem.getId(),
                problem.getDescription()
            });
        }
    }

    /**
     * Valida un incidente utilizando la lógica de negocio del servicio.
     *
     * @param incident Instancia de {@link Incident} a validar.
     */
    public void validateIncident(Incidente incident) {
        problemService.validateIncident(incident);
    }

    /**
     * Obtiene el primer problema en la cola.
     *
     * @return El primer problema en la cola.
     */
    public Problema peek() {
        return problemService.front();
    }

    /**
     * Elimina y retorna el primer problema en la cola.
     *
     * @return El problema eliminado de la cola.
     */
    public Problema dequeue() {
        return problemService.dequeue();
    }
}
