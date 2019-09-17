package com.example.taller2.numeros;

public class AleatoriosLogica extends Aleatorios {

    public int suma(){
        return this.getNumero1()+this.getNumero2();
    }

    public int resta(){
        return this.getNumero1()-this.getNumero2();
    }

    public int multiplicacion(){
        return this.getNumero1()*this.getNumero2();
    }

    public int division(){
        return this.getNumero1()/this.getNumero2();
    }

}
