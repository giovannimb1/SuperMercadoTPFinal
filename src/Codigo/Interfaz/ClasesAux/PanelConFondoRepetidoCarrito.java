package Codigo.Interfaz.ClasesAux;

import Codigo.Interfaz.Sesion;
import Codigo.Logica.Almacen;
import Codigo.Logica.Cliente;

import javax.swing.*;
import java.awt.*;

public class PanelConFondoRepetidoCarrito extends JPanel {

    private final Image fondo;

    //fondo repetido

    public PanelConFondoRepetidoCarrito(String direccion) {
        fondo = new ImageIcon(getClass().getResource(direccion)).getImage();
        setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, contadorDepixelesDeALTOO());
        // esto adapta el fondo hasta un maximo de pixeles pero me importa solo el alto
        //sacar el alto contando los productos totales
    }

    public int contadorDepixelesDeALTOO(){


        // System.out.println(Almacen.getInstancia().getProductos().size());

        //para calcular el tamaño de largo de la ventana

        return ((Cliente) Sesion.getUsuarioActivo()).getCarrito().getProductos().size() * 65;


    }



    //esto hace q se repita
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ancho = fondo.getWidth(this);
        int largo = fondo.getHeight(this);

        if (ancho <= 0 || largo <= 0) return;

        for (int x = 0; x < getWidth(); x += ancho) {
            for (int y = 0; y < getHeight(); y += largo) {
                g.drawImage(fondo, x, y, this);
            }
        }
    }
}

