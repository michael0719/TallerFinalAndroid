package com.example.taller2.posicionrandom;

import java.util.Random;

public class PosicionLogica extends Posicion{
    Random r=new Random();
    public int posicionrandom(){
        return r.nextInt(this.getNumeroMax());
    }
}
