package eventos;

import graficos.PanelCalculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Evento para los botones numericos
 *
 */
public class Numero implements ActionListener {

    private JTextField pantalla;//Pantalla de la calculadora

    //Constructor
    public Numero(){

        pantalla = PanelCalculadora.getPantalla();

    }//Fin constructor

    public void actionPerformed(ActionEvent ev){

        JButton btnFuente = (JButton) ev.getSource();
        String textoPantalla = pantalla.getText();//Se recupera el texto en la pantalla de la calculadora
        String numero = btnFuente.getText();
        if(textoPantalla.length() == 1 && textoPantalla.equalsIgnoreCase("0"))
            pantalla.setText(numero);
        else
            pantalla.setText(textoPantalla + numero);

    }

}
