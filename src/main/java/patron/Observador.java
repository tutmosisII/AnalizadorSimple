package patron;


import java.util.Observable;
import java.util.Observer;
import modelo.Opera;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Observador implements Observer{

    @Override
    public void update(Observable o, Object arg) {
        if(!(arg instanceof Opera)) 
            throw new IllegalArgumentException("Argumento invalido");
        Opera op=(Opera)arg;
        System.out.println(" Procesando: "+op.getOperando1()+" "+op.getOperando2()+ " "+ op.getOperador());
        switch (op.getOperador()) {
            case '+': op.setResultado(op.getOperando1()+op.getOperando2()); break;
            case '-': op.setResultado(op.getOperando1()-op.getOperando2()); break;
            case '*': op.setResultado(op.getOperando1()*op.getOperando2()); break;
            case '/': op.setResultado(op.getOperando1()/op.getOperando2()); break;
            case '^': op.setResultado(Math.pow(op.getOperando1(), op.getOperando2())); break;
                
        }
    }
    
}
