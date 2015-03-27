/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorsintactico;

import java.util.LinkedList;
import java.util.Observable;
import modelo.Opera;
import patron.Observador;

/**
 *
 * @author Alejandro
 */
public class AnalizadorSintactico extends Observable{

    public static  int matriz_prioridad[][]={
     //Infijo
    {1,1,0,0,0,0,1}, //+   P
    {1,1,0,0,0,0,1}, //-   I
    {1,1,1,1,0,0,1}, //*   L 
    {1,1,1,1,0,0,1}, ///   A
    {1,1,1,1,1,0,1}, //^
    {0,0,0,0,0,0,0}, //(
    {2,2,2,2,2,2,2}, //)  Esto nunca se presenta
    };

    public AnalizadorSintactico() {
       this.operacion= new LinkedList<>();
    }
    
    
    
    public  void infijoAPosfijo(char []infijo,char []posfijo){
        int i,j;
        char elemento;
        LinkedList<Character> pila=new LinkedList();
        i=0;
        j=-1;
        while(i<infijo.length){
//            System.out.println(new String(posfijo));
            if(operando(infijo[i])){
                char c=infijo[i++];
                posfijo[++j]=c;
                hayQueOperar(c);
            }else{
                while(!pila.isEmpty() &&
                       prioridad(pila.peek(), infijo[i])==1
                     ){
                    elemento = pila.pop();
                    posfijo[++j] = elemento;
                    hayQueOperar(elemento);
            
                }
                if(infijo[i] == ')')
                    elemento= pila.pop();
                else{
                    pila.push(infijo[i]);
                    
                }
                i++;
                
            }
        }
        //Retira los uotimos elementos que quedan en la pila
        while(!pila.isEmpty()){
            elemento = pila.pop();
            hayQueOperar(elemento);
            posfijo[++j] = '\0';
        }
    }
    
    private LinkedList<String> operacion;
    private void hayQueOperar(char elemento){
        if(!operando(elemento) && operacion.size()>=2){
            this.setChanged();
            Double op2=Double.parseDouble(operacion.pop());
            Double op1=Double.parseDouble(operacion.pop());

            Opera o=new Opera(op1, op2, elemento);
            notifyObservers(o);
            operacion.push(""+o.getResultado());
        }
        else{
           operacion.push(""+elemento);
        }
        
    }
    
    public boolean operando(char c){
        switch(c){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '(':
            case ')':
                return false;
            default:
                return true;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String infijo="2*2+(4^4)/2+(5*5)";
        System.out.println(infijo);
        char posfijo[]=new char[infijo.length()];
        AnalizadorSintactico ans=new AnalizadorSintactico();
        ans.addObserver(new Observador());
        ans.infijoAPosfijo(infijo.toCharArray(), posfijo);
        
        System.out.println(new String(posfijo));
    }

    private int prioridad(char pila,char infijo) {
        int i=-1,j=-1;
        switch(pila){
            case '+': i=0;break;
            case '-': i=1;break;
            case '*': i=2;break;
            case '/': i=3;break;
            case '^': i=4;break;
            case '(': i=5;break;
        }
        switch(infijo){
            case '+': j=0;break;
            case '-': j=1;break;
            case '*': j=2;break;
            case '/': j=3;break;
            case '^': j=4;break;
            case '(': j=5;break;
            case ')': j=6;break;
        }
        return matriz_prioridad[i][j];
    }
    
}
