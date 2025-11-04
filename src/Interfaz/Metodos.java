package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Metodos {


    //metodo texto default :v

    public static JLabel textoDefault(int x , int y, String texto) {
        JLabel aux = new JLabel(texto);
        aux.setForeground(Color.WHITE);
        aux.setFont(new Font("Arial", Font.PLAIN, 18));
        aux.setBounds(x, y, 100, 20);

        return aux;
    }

    public static JLabel armadoTicket(int x , int y, String infoCompras) {
        JLabel aux = new JLabel(infoCompras);
        aux.setForeground(Color.BLACK);
        aux.setFont(new Font("Arial", Font.PLAIN, 18));
        aux.setBounds(x, y, 100, 20);

        return aux;
    }



}
