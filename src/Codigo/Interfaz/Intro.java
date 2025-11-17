package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Logica.*;

import javax.swing.*;
import java.awt.*;

public class Intro extends JFrame {
    public Intro() {

        Metodos.ventanasConfiguracionnTipica(this, "Login / Registro");

        JPanel panel = new JPanel(null);
        add(panel);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/Intro/fondo.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 1280, 720);

        ImageIcon img2 = new ImageIcon(getClass().getResource("/img/Intro/panel412421.png"));
        JLabel inicio = new JLabel(img2);
        inicio.setBounds(0, 0, 1280, 720);

        JLabel usuarioT = Metodos.textoDefault(110, 350, "USUARIO", Color.BLACK);

        JTextField inUsuario = new JTextField();
        inUsuario.setBounds(110, 380, 200, 25);

        JLabel contranaT = Metodos.textoDefault(110, 420, "CONTRASEÑA", Color.BLACK);

        JPasswordField inContrasena = new JPasswordField();
        inContrasena.setBounds(110, 450, 200, 25);

        JButton registro = new JButton("Registrarse");
        registro.setBounds(110, 560, 200, 40);
        registro.setBackground(new Color(80, 150, 255));
        registro.setForeground(Color.WHITE);
        registro.setFocusPainted(false);

        registro.addActionListener(e -> {
            new RegistroUsuario().setVisible(true);
        });

        JButton iniciarSecion = new JButton("Iniciar");
        iniciarSecion.setBounds(110, 500, 200, 40);
        iniciarSecion.setBackground(new Color(80, 150, 255));
        iniciarSecion.setForeground(Color.WHITE);
        iniciarSecion.setFocusPainted(false);

        iniciarSecion.addActionListener(e -> {

            String us = inUsuario.getText();
            String pass = inContrasena.getText();

            try {

                Usuario u = Gestora.getInstancia().inicioSesion(us, pass);

                if (u.isPermisos()) {

                    Administrador administrador = (Administrador) u;

                    Sesion.setUsuarioActivo(administrador);

                } else {
                    Cliente cliente = (Cliente) u;

                    Sesion.setUsuarioActivo(cliente);


                }

                new Menu().setVisible(true);
                dispose();

            } catch (AutenticacionException ex) {
                Metodos.excepcionPantallaEmergente(ex.getMessage());
            }

        });

        panel.add(usuarioT);
        panel.add(contranaT);
        panel.add(inContrasena);
        panel.add(inUsuario);
        panel.add(registro);
        panel.add(iniciarSecion);
        panel.add(inicio);
        panel.add(fondo);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Intro().setVisible(true));
    }
}
