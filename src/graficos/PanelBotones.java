package graficos;

import javax.swing.*;
import java.awt.*;

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

                }else if(c == '.'){

                }else if(c == '+' || c == '-' || c == '*' || c == '/'){

                }

                add(botones[i][j]);//Se agrega el boton al panel

            }//Termina for
        }//Termina for

    }//Fin constructor

}
