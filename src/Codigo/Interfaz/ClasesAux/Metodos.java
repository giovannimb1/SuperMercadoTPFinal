package Codigo.Interfaz.ClasesAux;

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

    public static void ventanasConfiguracionnTipica(JFrame frame, String titulo) {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
                Metodos.class.getResource("/img/logos/logo.png")));
        frame.setTitle(titulo);
        frame.setSize(1280, 720); // puse las medidas promedio de las pantallas para no tener quilombo con el tema de adaptarse a cada pantalla
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public static void ventanasConfiguracionAlternativa(JFrame frame, String titulo) {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
                Metodos.class.getResource("/img/logos/logo.png")));
        frame.setTitle(titulo);
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

}