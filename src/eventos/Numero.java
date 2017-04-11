package eventos;

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
    public Numero(String numero, JTextField pantalla){

        this.pantalla = pantalla;

    }//Fin constructor

    public void actionPerformed(ActionEvent ev){

    }

}
