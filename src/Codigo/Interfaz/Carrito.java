package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class Carrito extends JFrame{
    public Carrito()  {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/img/logos/logo.png")));


        setTitle("SuperMercado");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(14, 21, 37));
        add(panel);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/Menu/1.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Menu/2.png"));
        JLabel decoracion1 = new JLabel(img2);
        decoracion1.setBounds(0, 0, 1280, 720);

        ImageIcon img3 = new ImageIcon(getClass().getResource("/img/Menu/3.png"));
        JLabel decoracion2 = new JLabel(img3);
        decoracion2.setBounds(0, 0, 1280, 720);

        ImageIcon img4 = new ImageIcon(getClass().getResource("/img/Menu/4.png"));
        JLabel logochiquito = new JLabel(img4);
        logochiquito.setBounds(0, 0, 1280, 720);


        JButton volverAlMenu = new JButton("Registrar Producto");
        volverAlMenu.setBounds(950, 67, 200, 40);
        volverAlMenu.setBackground(new Color(80, 150, 255));
        volverAlMenu.setForeground(Color.WHITE);
        volverAlMenu.setFocusPainted(false);
        volverAlMenu.addActionListener(e -> {
        new Menu().setVisible(true);

        dispose();


        });

        JButton ticket = new JButton("Finalizar Compra");
        ticket.setBounds(540, 600, 200, 40);
        ticket.setBackground(new Color(80, 150, 255));
        ticket.setForeground(Color.WHITE);
        ticket.setFocusPainted(false);

        ticket.addActionListener(e -> {

            Metodos.mensajeEmergente("Comprado Con exito");

        });

        panel.add(volverAlMenu);
        panel.add(ticket);
        panel.add(logochiquito);
        panel.add(decoracion1);
        // panel.add(decoracion2);
        panel.add(fondo);


        // JLabel ticket = Metodos.textoDefault(null, null, metodo) // aca poner el q retorna el ticket

        //panel.add(ticket);



    }

    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Carrito().setVisible(true));
    }
}
    

