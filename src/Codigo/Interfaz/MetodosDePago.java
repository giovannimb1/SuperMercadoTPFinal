package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;

import javax.swing.*;

public class MetodosDePago extends JFrame {

    public MetodosDePago() {

        Metodos.ventanasConfiguracionnTipica(this, "Metodos De Pago");

        JPanel panel = new JPanel(null);
        add(panel);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MetodosDePago/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);


        ImageIcon imge = new ImageIcon(getClass().getResource("/img/MetodosDePago/mp.png"));
        JButton metodo1 = new JButton(imge);
        metodo1.setBounds(200, 140, 373, 392);
        metodo1.setBorderPainted(false);
        metodo1.setContentAreaFilled(false);
        metodo1.setFocusPainted(false);

        metodo1.addActionListener(e -> {

            Metodos.excepcionPantallaEmergente("Pago Realizado");
            dispose();
        });

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/MetodosDePago/tarjetas.png"));
        JButton metodo2 = new JButton(img2);
        metodo2.setBounds(700, 140, 389, 395);

        metodo2.setBorderPainted(false);
        metodo2.setContentAreaFilled(false);
        metodo2.setFocusPainted(false);

        metodo2.addActionListener(e -> {
            Metodos.excepcionPantallaEmergente("Pago Realizado");
            dispose();
        });


        panel.add(metodo1);
        panel.add(metodo2);
        panel.add(fondo);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MetodosDePago().setVisible(true));
    }


}
