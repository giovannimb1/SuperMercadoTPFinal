package Codigo.Interfaz;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagenAdministrador extends JPanel {

    public static ImageIcon subirImagen(int ancho, int alto) {
        JFileChooser buscador = new JFileChooser();

        buscador.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "fotos (JPG, PNG)", "jpg", "jpeg", "png"
        ));

        int resultado = buscador.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = buscador.getSelectedFile();
            ImageIcon img = new ImageIcon(archivo.getAbsolutePath());
            Image imagenEscalada = img.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        }

        return null;
    }

}
