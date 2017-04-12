package eventos;

import graficos.PanelCalculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Evento para el boton AC
 */
public class BorrarDEL extends AbstractAction {

    private JTextField pantalla;

    //Constructor
    public BorrarDEL(){

        putValue(Action.NAME, "DEL");
        pantalla = PanelCalculadora.getPantalla();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String textoPantalla = pantalla.getText();
        int longitud = textoPantalla.length();

        if(longitud == 1 && !textoPantalla.equalsIgnoreCase("0")){

            pantalla.setText("0");

        }else if(longitud > 1){

            pantalla.setText(textoPantalla.substring(0, longitud - 1));

        }

    }
}
