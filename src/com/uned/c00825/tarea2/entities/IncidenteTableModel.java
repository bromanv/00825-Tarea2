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
public class IncidenteTableModel extends BaseTableModel<Incidente> {

    /**
     * Constructor por defecto que inicializa la lista de incidentes como vacía.
     */
    public IncidenteTableModel() {
        super(Incidente.class);
        this.columnNames = new String[]{
            "Id",
            "Usuario",
            "Categoria",
            "Fecha",
            "Detalle"
        };
    }
public IncidenteTableModel(Iterator<Incidente> datos){        
        super(Incidente.class,datos);
        this.columnNames = new String[]{
            "Id",
            "Usuario",
            "Categoria",
            "Fecha",
            "Detalle"
        };
    }

    /**
     * Obtiene el valor para una celda específica (fila/columna), accediendo a
     * la propiedad adecuada del {@link Incidente} correspondiente.
     *
     * @param rowIndex Índice de la fila en la tabla.
     * @param columnIndex Índice de la columna en la tabla.
     * @return El valor del atributo del incidente que corresponda a la columna.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0 && data.length > rowIndex) {
        Incidente incident = data[rowIndex];
        if (incident != null) {
            switch (columnIndex) {
                case 0:
                    return incident.getId();
                case 1:
                    return incident.getRequester();
                case 2:
                    return incident.getCategory();
                case 3:
                    return incident.getDate();
                case 4:
                    return incident.getDetails();
            }
        }
        }
        return null;
    }

   }
