/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejandro
 */
public class Opera {
    private double operando1;
    private double operando2;
    private char operador;
    private double resultado;

    public Opera(double operando1, double operando2, char operador) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
    }
    
    

    /**
     * @return the operando1
     */
    public double getOperando1() {
        return operando1;
    }

    /**
     * @param operando1 the operando1 to set
     */
    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    /**
     * @return the operando2
     */
    public double getOperando2() {
        return operando2;
    }

    /**
     * @param operando2 the operando2 to set
     */
    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    /**
     * @return the operador
     */
    public char getOperador() {
        return operador;
    }

    /**
     * @param operador the operador to set
     */
    public void setOperador(char operador) {
        this.operador = operador;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return " Procesando: "+operando1+" "+operando2+ " "+ operador;
    }

    
    
    
}
