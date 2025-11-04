package Interfaz;

import Logica.Producto;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {

        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));
        add(panel);

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setBounds(0, 0, 1280, 720);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll);

    }

    private void productorAvisual(Producto producto){


/*Tengo que hacer la cuadricula con toda la info pero no me decido todavia como hacerla :V*/
    }




    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu().setVisible(true));
    }
}
