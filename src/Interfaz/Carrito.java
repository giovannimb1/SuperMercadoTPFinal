package Interfaz;

import javax.swing.*;
import java.awt.*;

public class Carrito extends JFrame{
    public Carrito()  {


        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));
        add(panel);

        // JLabel ticket = Metodos.textoDefault(null, null, metodo) // aca poner el q retorna el ticket

        //panel.add(ticket);


    }

    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Carrito().setVisible(true));
    }
}
    

