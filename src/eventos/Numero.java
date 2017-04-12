package eventos;

import graficos.PanelCalculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento para los botones numericos
 *
 */
public class Numero extends AbstractAction {

    private JTextField pantalla;//Pantalla de la calculadora
    private String numero;

    //Constructor
    public Numero(String num){

        pantalla = PanelCalculadora.getPantalla();
        numero = num;
        putValue(Action.NAME, num);

    }//Fin constructor

    public void actionPerformed(ActionEvent ev){

        String textoPantalla = pantalla.getText();//Se recupera el texto en la pantalla de la calculadora

        if(textoPantalla.length() == 1 && textoPantalla.equalsIgnoreCase("0"))
            pantalla.setText(numero);
        else
            pantalla.setText(textoPantalla + numero);

    }

}
