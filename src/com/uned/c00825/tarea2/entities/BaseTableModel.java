/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.entities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author byron
 */
public abstract class BaseTableModel<T extends BaseEntity> extends AbstractTableModel {

    /**
     * Lista interna de entidades, implementada con un arreglo para facilitar
     * operaciones de inserción y eliminación de forma eficiente.
     */
    protected T[] data;
    protected int lastIndex = -1;
    /**
     * Nombres de las columnas que se mostrarán en la tabla, mapeados a
     * propiedades específicas de la entidad.
     */
    protected String[] columnNames;

    protected Class<?> entityClass;

    /**
     * Constructor por defecto que inicializa la lista de entidades como vacía.
     */
    public BaseTableModel(Class<?> entityClass) {
        this.entityClass = entityClass;
        data = (T[]) Array.newInstance(entityClass, 0);
    }

    /**
     * Constructor que recibe un {@link Iterator} de entidades para iniciar el
     * modelo con datos existentes.
     *
     * @param entities Lista de entidades a gestionar en este modelo.
     */
    public BaseTableModel(Class<?> entityClass, Iterator<T> entities) {
         this(entityClass);
        while (entities.hasNext()) {
            addRow(entities.next());
        }

    }

    /**
     * Indica el número total de filas en la tabla, que coincide con la cantidad
     * de entidades administradas por el modelo.
     *
     * @return Entero representando la cantidad de entidades.
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * Retorna el número de columnas definido por {@code columnNames}.
     *
     * @return Entero que indica cuántas columnas se mostrarán.
     */
    @Override
    public int getColumnCount() {
        return columnNames == null ? 0 : columnNames.length;
    }

    /**
     * Provee el nombre correspondiente a cada columna, en función de su
     * posición en el arreglo {@code columnNames}.
     *
     * @param column Índice de la columna solicitada.
     * @return Cadena con el título de la columna.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames == null ? "" : columnNames[column];
    }

    /**
     * Determina si las celdas de la tabla son editables. En este caso, se
     * devuelve {@code false} para deshabilitar la edición directa de la tabla y
     * canalizar los cambios a través de formularios o métodos especializados.
     *
     * @param rowIndex Fila seleccionada.
     * @param columnIndex Columna seleccionada.
     * @return {@code false} indicando que no hay edición en la celda.
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    /**
     * Notifica a todos los listeners que los datos han sido modificados,
     * forzando una actualización de la vista.
     */
    public void fireDataChanged() {
        fireTableDataChanged();
    }

    /**
     * Recupera la entidad que se encuentra en la posición especificada.
     *
     * @param rowIndex Fila de la cual se desea obtener la entidad.
     * @return Instancia de {@link BaseEntity} en la posición dada.
     */
    public T getEntityAt(int rowIndex) {
        return data[rowIndex];
    }

    /**
     * Agrega una nueva entidad al final de la lista y, de manera implícita,
     * a la tabla asociada.
     *
     * @param entity Objeto {@link BaseEntity} que se desea añadir.
     */
    public void addRow(T entity) {
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
        this.data[++lastIndex] = entity;
    }

    /**
     * Ajusta la cantidad de filas del modelo, regenerando la lista interna de
     * entidades. Se utiliza una lista temporal para eliminar datos previos.
     *
     * @param rowCount Número de filas que quedarán definidas en el modelo.
     */
    public void setRowCount(int rowCount) {
         this.data = Arrays.copyOf(this.data, rowCount);
    }

    protected T[] createNewArray(int capacity) {
        return (T[]) Array.newInstance(entityClass, capacity);
    }

}
