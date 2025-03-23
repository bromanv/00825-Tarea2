/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uned.c00825.tarea2.da;

import com.uned.c00825.tarea2.entities.Incidente;

/**
 *
 * @author byron
 */
public class PilaIncidente extends PilaGenerica<Incidente> {
    
    private static int NEXT_ID = 1;
    public PilaIncidente() {
        super(Incidente.class);
    }
    @Override
    protected int getId() {
        return NEXT_ID++;
    }
}
