package graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que define las caracteristicas del panel principal de la calculadora
 *
 */

public class PanelCalculadora extends JPanel {

    private JTextField pantalla;//Campo de texto que simula ser la pantalla de la calculadora

    //Constructor
    public PanelCalculadora(){

        setLayout(new BorderLayout());//El panel tiene un layout de tipo BorderLayout+

        pantalla = new JTextField();//Inicializacion del field pantalla

        //-------Caracteristicas del field pantalla---------------------------------------------------------------------
        pantalla.setFont(new Font("Arial", 1, 32));
        pantalla.setMargin(new Insets(25,5,25,5));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                char tecla = e.getKeyChar();//Se recupera la tecla pulsada
                String expresionPantalla = pantalla.getText();//Se recupera lo que este escrito en la pantalla

                if(!Character.isDigit(tecla)){//Si el caracter pulsado no es un digito, se evalua que sea un - ó .
                    if(tecla == '.'){
                        for(int i = 0; i < expresionPantalla.length(); ++i){//Recorre la expresion caracter por caracter
                            if(expresionPantalla.charAt(i) == '.'){//Si ya se ha escrito un punto, entonces no se permite escribir otro
                                e.consume();//El evento no hara nada
                                break;//Sale del bucle for
                            }
                        }
                    }else if(tecla == '-'){
                        if(expresionPantalla == "0")
                            pantalla.setText("-");
                        else if(expresionPantalla != "")
                            e.consume();
                    }else{
                        e.consume();//El evento no hace nada
                    }
                }

            }
        });
        //--------------------------------------------------------------------------------------------------------------

        PanelBotones pnlBotones = new PanelBotones();//Se crea instancia de la clase PanelBotones

        add(pantalla, BorderLayout.NORTH);//Coloca la "pantalla" en la parte superior del panel
        add(pnlBotones, BorderLayout.CENTER);//El grid con los botones se coloca en el centro
    }//Fin constructor



}
