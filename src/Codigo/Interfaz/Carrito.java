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

        JButton ticket = new JButton("Finalizar Compra");
        ticket.setBounds(540, 600, 200, 40);
        ticket.setBackground(new Color(80, 150, 255));
        ticket.setForeground(Color.WHITE);
        ticket.setFocusPainted(false);

        ticket.addActionListener(e -> {
            System.out.println(/*aca q retorne la lista de productos*/);

        });

        panel.add(ticket);


        // JLabel ticket = Metodos.textoDefault(null, null, metodo) // aca poner el q retorna el ticket

        //panel.add(ticket);



    }

    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Carrito().setVisible(true));
    }
}
    

