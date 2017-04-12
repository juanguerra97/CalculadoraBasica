package eventos;

import graficos.PanelCalculadora;
import principal.Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Evento que es llamado cuando se pulsa el boton de suma, resta, etc.
 */

public class Operacion extends AbstractAction {

    private JTextField pantalla;
    private char operador;

    //Constructor
    public Operacion(String nombre){

        operador = nombre.charAt(0);
        pantalla = PanelCalculadora.getPantalla();
        putValue(Action.NAME, nombre);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double operando = Double.parseDouble(pantalla.getText());

        if(operando == 0 && Calculadora.ultimaOperacion() == '/'){
            JOptionPane.showMessageDialog(null, "NO ES POSIBLE DIVIDIR ENTRE CERO!!!");
        }else{

            Calculadora.agregarOperando(operando);
            Calculadora.agregarOperador(operador);
            pantalla.setText("0");

        }

    }
}
