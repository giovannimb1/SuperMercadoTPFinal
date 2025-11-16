package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelConFondoRepetido extends JPanel {

    private final Image fondo;

    public PanelConFondoRepetido(String ruta) {
        fondo = new ImageIcon(getClass().getResource(ruta)).getImage();
        setLayout(null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 2000);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = fondo.getWidth(this);
        int h = fondo.getHeight(this);

        if (w <= 0 || h <= 0) return;

        for (int x = 0; x < getWidth(); x += w) {
            for (int y = 0; y < getHeight(); y += h) {
                g.drawImage(fondo, x, y, this);
            }
        }
    }
}
