/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.uned.c00825.tarea2.gui;

import com.uned.c00825.tarea2.controllers.ProblemaController;
import com.uned.c00825.tarea2.entities.Incidente;
import com.uned.c00825.tarea2.entities.IncidenteTableModel;
import com.uned.c00825.tarea2.entities.Problema;
import com.uned.c00825.tarea2.entities.ProblemaTableModel;
import com.uned.c00825.tarea2.validators.EntityValidationException;
import java.awt.CardLayout;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author byron
 */
public class FrmProblemaTraslado extends javax.swing.JFrame {

    private int currentStep = 0;

    /**
     * Creates new form NewJFrame
     *
     * @param controller
     */
    public FrmProblemaTraslado(ProblemaController controller) {
        problemaController = controller;
        initComponents();
        wizard = (CardLayout) pnlRoot.getLayout();
        setLocationRelativeTo(null);
        initTableModel(); // Aquí se inicializa el modelo de la tabla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRoot = new javax.swing.JPanel();
        pnlProblemas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        spProblemasOrigen = new javax.swing.JScrollPane();
        tblProblemasOrigen = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        pnlProblemasDestino = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        spProblemasDestino = new javax.swing.JScrollPane();
        tblProblemasDestino = new javax.swing.JTable();
        btnTrasladar = new javax.swing.JButton();
        pnlFooter = new javax.swing.JPanel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminación de incidentes ");
        setMinimumSize(new java.awt.Dimension(670, 400));
        setPreferredSize(new java.awt.Dimension(670, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        pnlRoot.setMinimumSize(new java.awt.Dimension(100, 400));
        pnlRoot.setPreferredSize(new java.awt.Dimension(640, 310));
        pnlRoot.setLayout(new java.awt.CardLayout());

        pnlProblemas.setMinimumSize(new java.awt.Dimension(50, 50));
        pnlProblemas.setPreferredSize(new java.awt.Dimension(620, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 290));

        spProblemasOrigen.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spProblemasOrigen.setMaximumSize(new java.awt.Dimension(610, 100));
        spProblemasOrigen.setName(""); // NOI18N
        spProblemasOrigen.setPreferredSize(new java.awt.Dimension(610, 402));

        tblProblemasOrigen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProblemasOrigen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblProblemasOrigen.setFillsViewportHeight(true);
        tblProblemasOrigen.setRowSorter(null);
        tblProblemasOrigen.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProblemasOrigen.setShowGrid(true);
        spProblemasOrigen.setViewportView(tblProblemasOrigen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spProblemasOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spProblemasOrigen, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Seleccione el problema y presione siguiente");

        javax.swing.GroupLayout pnlProblemasLayout = new javax.swing.GroupLayout(pnlProblemas);
        pnlProblemas.setLayout(pnlProblemasLayout);
        pnlProblemasLayout.setHorizontalGroup(
            pnlProblemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProblemasLayout.createSequentialGroup()
                .addGroup(pnlProblemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProblemasLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProblemasLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        pnlProblemasLayout.setVerticalGroup(
            pnlProblemasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProblemasLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pnlRoot.add(pnlProblemas, "card1");

        pnlProblemasDestino.setMinimumSize(new java.awt.Dimension(635, 33));
        pnlProblemasDestino.setPreferredSize(new java.awt.Dimension(635, 320));

        jPanel2.setMaximumSize(new java.awt.Dimension(800, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 250));

        spProblemasDestino.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        spProblemasDestino.setMaximumSize(new java.awt.Dimension(610, 100));
        spProblemasDestino.setName(""); // NOI18N
        spProblemasDestino.setPreferredSize(new java.awt.Dimension(610, 402));

        tblProblemasDestino.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProblemasDestino.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblProblemasDestino.setFillsViewportHeight(true);
        tblProblemasDestino.setRowSorter(null);
        tblProblemasDestino.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProblemasDestino.setShowGrid(true);
        spProblemasDestino.setViewportView(tblProblemasDestino);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spProblemasDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(spProblemasDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlProblemasDestino.add(jPanel2);

        btnTrasladar.setText("Trasladar incidentes");
        btnTrasladar.setName("btnTrasladar"); // NOI18N
        btnTrasladar.setPreferredSize(new java.awt.Dimension(130, 23));
        btnTrasladar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrasladarActionPerformed(evt);
            }
        });
        pnlProblemasDestino.add(btnTrasladar);

        pnlRoot.add(pnlProblemasDestino, "card2");

        getContentPane().add(pnlRoot);

        pnlFooter.setEnabled(false);
        pnlFooter.setFocusable(false);
        pnlFooter.setPreferredSize(new java.awt.Dimension(640, 43));

        btnNext.setText("Siguiente");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setText("Anterior");
        btnBack.setEnabled(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlFooter);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrasladarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrasladarActionPerformed
        trarladarIncidente();
    }//GEN-LAST:event_btnTrasladarActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        currentStep++;
        wizard.next(pnlRoot);
        if (pnlRoot.getComponentCount() <= currentStep) {
            currentStep = 0;
            btnBack.setEnabled(false);
        } else {
            if (!btnBack.isEnabled()) {
                btnBack.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        currentStep--;
        wizard.previous(pnlRoot);
        if (btnBack.isEnabled() && currentStep == 0)
            btnBack.setEnabled(false);
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * Método que simula el binding entre la interfaz y el modelo. Lee los datos
     * de los componentes, crea un objeto Problema y lo envía al controlador.
     */
    private void trarladarIncidente() {
        try {
            if (sourceSelectedItem != null) {
                Incidente item;
                do {
                    item = sourceSelectedItem.getIncidents().dequeue();
                    if (item != null) {
                        destinationSelectedItem.getIncidents().add(item);
                    }
                } while (item != null);
                initTableModel();
                tblProblemasOrigen.updateUI();
                btnNextActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(this, "Debe selecconar un problema",
                        "Atención", JOptionPane.WARNING_MESSAGE);
            }

        } catch (EntityValidationException ex) {
            // Para notificar errores se utiliza un cuadro de diálogo; según el enunciado, se debe limitar su uso a excepciones.
            JOptionPane.showMessageDialog(this, "Validaciones no superadas: " + ex.getValidationResult()
                    .getErrors()
                    .stream()
                    .map(e -> e.getMessage())
                    .collect(Collectors.joining("\n\t")),
                    "Atención", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            // Para notificar errores se utiliza un cuadro de diálogo; según el enunciado, se debe limitar su uso a excepciones.
            JOptionPane.showMessageDialog(this, "Error al registrar el problema: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initTableModel() {

        // Definimos las columnas según los datos que queremos mostrar
        sourceTableModel = new ProblemaTableModel(problemaController.getAll((t) -> t != null && t.getId() > 0 && t.getIncidents().size() > 2));
        // Asignamos el modelo a la tabla
        tblProblemasOrigen.setModel(sourceTableModel);

        tblProblemasOrigen.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            int idx = tblProblemasOrigen.getSelectedRow();
            btnNext.setEnabled(idx >= 0);
            if (idx >= 0) {
                idx = tblProblemasOrigen.convertRowIndexToModel(idx);
                sourceSelectedItem = sourceTableModel.getEntityAt(idx);
                cargarDestinos();
            }
        });

    }

    private void cargarDestinos() {
        // Definimos las columnas según los datos que queremos mostrar
        destinationTableModel = new ProblemaTableModel(problemaController.getAll((t) -> t != null && t.getId() > 0 && t.getId() != sourceSelectedItem.getId()));
        // Asignamos el modelo a la tabla
        tblProblemasDestino.setModel(destinationTableModel);

        tblProblemasDestino.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            int idx = tblProblemasDestino.getSelectedRow();
            btnNext.setEnabled(idx >= 0);
            if (idx >= 0) {
                idx = tblProblemasDestino.convertRowIndexToModel(idx);
                destinationSelectedItem = destinationTableModel.getEntityAt(idx);
            }
        });
        tblProblemasDestino.updateUI();
    }
    private ProblemaTableModel destinationTableModel;
    private ProblemaTableModel sourceTableModel;

    private ProblemaController problemaController;
    private Problema sourceSelectedItem;
    private Problema destinationSelectedItem;

    private CardLayout wizard;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnTrasladar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlProblemas;
    private javax.swing.JPanel pnlProblemasDestino;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JScrollPane spProblemasDestino;
    private javax.swing.JScrollPane spProblemasOrigen;
    private javax.swing.JTable tblProblemasDestino;
    private javax.swing.JTable tblProblemasOrigen;
    // End of variables declaration//GEN-END:variables
}
