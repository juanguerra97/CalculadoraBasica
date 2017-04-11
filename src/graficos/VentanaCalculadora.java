package graficos;

import javax.swing.JFrame;

/**
 * Clase que define las caracteristicas de la ventana de la aplicación
 *
 */

public class VentanaCalculadora extends JFrame {

    //Constructor, sin argumentos
    public VentanaCalculadora(){

        setSize(550,320);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculadora Básica");

        PanelCalculadora pnlCalculadora = new PanelCalculadora();//Se instancia la clase PanelCalculadora

        add(pnlCalculadora);//Se coloca el panel pnlCalculadora sobre la ventana

    }//Fin constructor

}
