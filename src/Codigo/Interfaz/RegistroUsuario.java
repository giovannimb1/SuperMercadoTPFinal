package Codigo.Interfaz;

import Codigo.Interfaz.ClasesAux.Metodos;
import Codigo.Logica.*;

import javax.swing.*;
import java.awt.*;

public class RegistroUsuario extends JFrame {

    public RegistroUsuario() {

        Metodos.ventanasConfiguracionAlternativa(this, "Registro Usuariosw");

        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(255, 255, 255));
        add(panel);
        JLabel text1 = Metodos.textoDefault(125, 80, "NOMBRE", Color.BLACK);
        JLabel text2 = Metodos.textoDefault(125, 130, "APELLIDO", Color.BLACK);
        JLabel text4 = Metodos.textoDefault(125, 180, "USUARIO", Color.BLACK);
        JLabel text5 = Metodos.textoDefault(125, 230, "EMAIL", Color.BLACK);
        JLabel text3 = Metodos.textoDefault(125, 280, "CONTRASEÑA", Color.BLACK);
        JLabel text6 = Metodos.textoDefault(125, 330, "REPETIR", Color.BLACK);

        JTextField inNombre = new JTextField();
        inNombre.setBounds(275, 80, 200, 25);

        JTextField inApellido = new JTextField();
        inApellido.setBounds(275, 130, 200, 25);

        JTextField inEmail = new JTextField();
        inEmail.setBounds(275, 230, 200, 25);

        JTextField inUsername = new JTextField();
        inUsername.setBounds(275, 180, 200, 25);

        JPasswordField inPassword = new JPasswordField();
        inPassword.setBounds(275, 280, 200, 25);

        JPasswordField inPasswordRepeticion = new JPasswordField();
        inPasswordRepeticion.setBounds(275, 330, 200, 25);

        ImageIcon img = new ImageIcon(getClass().getResource("/img/MicroMenu/fondoM.png"));
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, 600, 500);

        JButton cerrar = new JButton("Cerrar");
        cerrar.setBounds(80, 400, 200, 40);
        cerrar.setBackground(new Color(255, 49, 49));
        cerrar.setForeground(Color.WHITE);
        cerrar.setFocusPainted(false);
        cerrar.addActionListener(e -> dispose());

        JButton boton = new JButton("Registrarse");
        boton.setBounds(320, 400, 200, 40);
        boton.setBackground(new Color(80, 150, 255));
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);

        boton.addActionListener(e -> {

            String nombre = inNombre.getText();
            String apellido = inApellido.getText();
            String email = inEmail.getText();
            String user = inUsername.getText();
            String pass = new String(inPassword.getPassword());
            String pass2 = new String(inPasswordRepeticion.getPassword());

            if(pass.compareTo(pass2) == 0){
                Cliente cliente = new Cliente(nombre,apellido,user,email,pass);

                if (Gestora.getInstancia().agregar(cliente)) {
                    Metodos.excepcionPantallaEmergente("Agregado con exito");
                    dispose();


                } else {
                    Metodos.excepcionPantallaEmergente( "Error");
                }
            }else {
                Metodos.excepcionPantallaEmergente("La contraseña no es la misma en los 2 campos");
    
            }



        });

        panel.add(inNombre);
        panel.add(inApellido);
        panel.add(inPassword);
        panel.add(inUsername);
        panel.add(inEmail);
        panel.add(inPasswordRepeticion);
        panel.add(text1);
        panel.add(text2);
        panel.add(text3);
        panel.add(text4);
        panel.add(text5);
        panel.add(text6);
        panel.add(boton);
        panel.add(cerrar);
        panel.add(fondo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroUsuario().setVisible(true));
    }
}
