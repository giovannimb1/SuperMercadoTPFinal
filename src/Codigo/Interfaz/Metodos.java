package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Metodos extends JFrame {


    //metodo texto default :v

    public static JLabel textoDefault(int x, int y, String texto, Color color) {
        JLabel aux = new JLabel(texto);
        aux.setForeground(color);
        aux.setFont(new Font("Arial", Font.PLAIN, 18));
        aux.setBounds(x, y, 100, 20);

        return aux;
    }

    public static JLabel textoProductos(int x, int y, String info, Color color) {
        JLabel aux = new JLabel(info);
        aux.setForeground(color);
        aux.setBounds(20, 20, 200, 30);

        return aux;
    }


    public static void excepcionPantallaEmergente(String mensaje) {
// esto seria como una excepcion visual
        JOptionPane.showMessageDialog(null, mensaje);

    }

    public static void mensajeEmergente(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje);

    }

    public static JButton botonesCategorias(int x, int y,String texto)
    {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, 25, 25);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        return boton;
    }
}