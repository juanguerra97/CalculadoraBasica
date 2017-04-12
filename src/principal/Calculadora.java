package principal;

import graficos.PanelCalculadora;

import javax.swing.*;

/**
 * Clase que realiza las operaciones de la calculadora
 */
public class Calculadora {

    private static double operandos[] = new double[50];
    private static char operadores[] = new char[49];
    private static int contadorOperandos = 0;
    private static int contadorOperadores = 0;
    private static JTextField pantalla = PanelCalculadora.getPantalla();

    public static void agregarOperando(double nuevo){

        operandos[contadorOperandos] = nuevo;
        ++contadorOperandos;

    }

    public static void agregarOperador(char nuevo){

        operadores[contadorOperadores] = nuevo;
        ++contadorOperadores;

    }

    public static void resetear(){

        contadorOperadores = 0;
        contadorOperandos = 0;

    }

    public static void operar(){

        if(contadorOperandos == contadorOperadores)
            --contadorOperadores;

        double resultado = operandos[0];

        for(int i = 0; i < contadorOperadores; ++i){
            switch(operadores[i]){

                case '+':
                    resultado+=operandos[i+1];
                    break;
                case '-':
                    resultado-=operandos[i+1];
                    break;
                case '*':
                    resultado*=operandos[i+1];
                    break;
                case '/':
                    resultado/=operandos[i+1];
                    break;
                default://NO DEBERIA LLEGAR AQUI
                    break;

            }
        }

        pantalla.setText("" + resultado);

    }

    public static char ultimaOperacion(){
        if(contadorOperadores > 0)
            return operadores[contadorOperadores - 1];
        else
            return '+';
    }

}
