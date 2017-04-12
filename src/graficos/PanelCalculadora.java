package graficos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que define las caracteristicas del panel principal de la calculadora
 *
 */

public class PanelCalculadora extends JPanel {

    private static JTextField pantalla = new JTextField();//Campo de texto que simula ser la pantalla de la calculadora

    //Constructor
    public PanelCalculadora(){

        setLayout(new BorderLayout());//El panel tiene un layout de tipo BorderLayout

        //-------Caracteristicas del field pantalla---------------------------------------------------------------------
        pantalla.setFont(new Font("Arial", 1, 32));
        pantalla.setMargin(new Insets(25,5,25,5));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false);
        pantalla.setText("0");
        pantalla.setBackground(Color.WHITE);
        pantalla.setForeground(new Color(38,50,56));
        //--------------------------------------------------------------------------------------------------------------

        PanelBotones pnlBotones = new PanelBotones();//Se crea instancia de la clase PanelBotones

        add(pantalla, BorderLayout.NORTH);//Coloca la "pantalla" en la parte superior del panel
        add(pnlBotones, BorderLayout.CENTER);//El grid con los botones se coloca en el centro
    }//Fin constructor

    public static JTextField getPantalla(){
        return pantalla;
    }

}
