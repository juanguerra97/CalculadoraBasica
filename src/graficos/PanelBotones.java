package graficos;

import eventos.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Definicion del panel que contiene los botones de la calculadora
 *
 */

public class PanelBotones extends JPanel {

    //Constructor
    public PanelBotones(){

        setLayout(new GridLayout(3,6));//El panel tiene layout de grid de 4x5

        String signos[][] = {{"7","8","9","DEL","AC","="},//Simbolos que estaran en los botones
                            {"4","5","6","+","-","*"},
                            {"1","2","3",".","/","0"}
                            };
        JButton botones[][] = new JButton[3][6];//Arreglo con los botones

        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 6; ++j){
                botones[i][j] = new JButton(signos[i][j]);//Inicializacion del boton en la posicion i,j del arreglo botones

                botones[i][j].setFont(new Font("",1,20));

                char c = signos[i][j].charAt(0);
                if(Character.isDigit(c)){

                    ActionListener eventoNumerico = new Numero();
                    botones[i][j].addActionListener(eventoNumerico);

                }else if(c == '.'){

                    JTextField pantalla = PanelCalculadora.getPantalla();
                    botones[i][j].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            int puntos = 0;
                            String textoPantalla = pantalla.getText();
                            for(int i = 0; i < textoPantalla.length(); ++i){
                                if(textoPantalla.charAt(i) == '.'){
                                    ++puntos;
                                    break;
                                }
                            }
                            if(0 == puntos){
                                pantalla.setText(textoPantalla + '.');
                            }
                        }
                    });

                }else if(c == '+' || c == '-' || c == '*' || c == '/'){

                    InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
                    ActionMap mapaAccion = getActionMap();

                    AbstractAction eventoOperacion = new Operacion(signos[i][j]);

                    mapaEntrada.put(KeyStroke.getKeyStroke(signos[i][j].charAt(0)), "operacion" + signos[i][j]);
                    mapaAccion.put("operacion" + signos[i][j], eventoOperacion);

                    botones[i][j].setAction(eventoOperacion);

                }

                add(botones[i][j]);//Se agrega el boton al panel

            }//Termina for
        }//Termina for

        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaAccion = getActionMap();

        AbstractAction eventoBorrarDEL = new BorrarDEL();
        mapaEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "borrarDEL");
        mapaAccion.put("borrarDEL", eventoBorrarDEL);
        botones[0][3].setAction(eventoBorrarDEL);

        AbstractAction eventoBorrarAC = new BorrarAC();
        mapaEntrada.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0), "borrarAC");
        mapaAccion.put("borrarAC", eventoBorrarAC);
        botones[0][4].setAction(eventoBorrarAC);

        AbstractAction eventoIgual = new Igual();
        mapaEntrada.put(KeyStroke.getKeyStroke('\n'), "igual");
        mapaAccion.put("igual", eventoIgual);
        botones[0][5].setAction(eventoIgual);

    }//Fin constructor

}
