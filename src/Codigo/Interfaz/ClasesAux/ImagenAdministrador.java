package Codigo.Interfaz.ClasesAux;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagenAdministrador extends JFrame {

    public static String direccionDeIMG() {
        JFileChooser buscador = new JFileChooser();


        //esto es el explorador de archivos con las extensiones permitidas
        buscador.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "fotos (JPG, PNG)", "jpg", "jpeg", "png"
        ));

        int resultado = buscador.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = buscador.getSelectedFile(); // esto es el archivo
            ImageIcon img = new ImageIcon(archivo.getAbsolutePath());
            Image imagenEscalada = img.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);


            System.out.println("direccion = " + archivo.toString());


            return archivo.getAbsolutePath().replace("\\", "/");

        }
        return null;

    }


}
