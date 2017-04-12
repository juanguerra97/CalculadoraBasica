package eventos;

import graficos.PanelCalculadora;
import principal.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *  Evento que es desencadenado cuando se presiona el boton =
 */
public class Igual extends AbstractAction {

    private JTextField pantalla;

    //Constructor
    public Igual(){

        putValue(Action.NAME, "=");
        pantalla = PanelCalculadora.getPantalla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double operando = Double.parseDouble(pantalla.getText());

        if(operando == 0 && Calculadora.ultimaOperacion() == '/'){
            JOptionPane.showMessageDialog(null, "NO ES POSIBLE DIVIDIR ENTRE CERO!!!");
            Calculadora.resetear();
        }else{
            Calculadora.agregarOperando(operando);
            Calculadora.operar();
            Calculadora.resetear();
        }

    }
}
