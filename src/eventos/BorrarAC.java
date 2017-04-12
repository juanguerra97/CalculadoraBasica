package eventos;

import graficos.PanelCalculadora;
import principal.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Evento para el boton AC
 */
public class BorrarAC extends AbstractAction {

    private JTextField pantalla;

    //Constructor
    public BorrarAC(){

        putValue(Action.NAME, "AC");
        pantalla = PanelCalculadora.getPantalla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pantalla.setText("0");
        Calculadora.resetear();

    }
}
