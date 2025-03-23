/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.da;

import com.uned.c00825.tarea2.entities.Incidente;
import com.uned.c00825.tarea2.entities.Problema;
import java.time.LocalDate;

/**
 *
 * @author byron
 */
public class ColaProblema extends ColaGenerica<Problema> {

    private static int NEXT_ID = 1;

    public ColaProblema() {
        super(Problema.class);
    }

    @Override
    protected int getId() {
        return NEXT_ID++;
    }

    /**
     * Carga datos de prueba en la cola de problemas.
     */
    @Override
    protected void loadDummyData() {
        for (int c = 0; c < 5; c++) {
            Problema problem = new Problema(String.format("%05d-Problem ", c + 1));
            if (c % 2 == 0) {
                for (int i = 0; i < c; i++) {
                    problem.getIncidents().push(new Incidente(problem.getDescription(), "Software", "Details: " + problem.getDescription(), LocalDate.now().minusDays(c + i)));
                }
            }
            add(problem);
        }
    }
}
