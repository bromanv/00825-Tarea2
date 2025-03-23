/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.entities;

import java.util.Iterator;

/**
 *
 * @author byron
 */
public class ProblemaTableModel extends BaseTableModel<Problema> {

    /**
     * Constructor por defecto que inicializa la lista de problemas como vacía.
     */
    public ProblemaTableModel() {
        super(Problema.class);
        this.columnNames = new String[]{
            "ID",
            "Description"
        };
    }

/**
     * Constructor que inicializa el modelo con una lista de problemas.
     *
     * @param data Iterador de problemas para inicializar el modelo.
     */
    public ProblemaTableModel(Iterator<Problema> data) {
        super(Problema.class, data);
        this.columnNames = new String[]{
            "ID",
            "Description"
        };
    }

    /**
     * Obtiene el valor para una celda específica (fila/columna), accediendo a
     * la propiedad adecuada del {@link Problema} correspondiente.
     *
     * @param rowIndex Índice de la fila en la tabla.
     * @param columnIndex Índice de la columna en la tabla.
     * @return El valor del atributo del problema que corresponda a la columna.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && data.length > rowIndex) {
            Problema problem = data[rowIndex];
            if (problem != null) {
                switch (columnIndex) {
                    case 0:
                        return problem.getId();
                    case 1:
                        return problem.getDescription();
                }
            }
        }
        return null;
    }

    /**
     * Ajusta la cantidad de filas del modelo, regenerando la lista interna de
     * problemas. Se utiliza una lista temporal para eliminar datos previos.
     *
     * @param i Número de filas que quedarán definidas en el modelo.
     */
    @Override
    public void setRowCount(int i) {
        
    }

}
