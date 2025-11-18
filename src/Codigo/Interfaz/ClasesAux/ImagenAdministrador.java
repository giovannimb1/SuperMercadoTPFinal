package Codigo.Interfaz.ClasesAux;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagenAdministrador extends JFrame {

    public static String direccionDeIMG() {
        JFileChooser buscador = new JFileChooser(); // explorador de archivos


        //esto es el explorador de archivos con las extensiones permitidas
        buscador.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "fotos (JPG, PNG)", "jpg", "jpeg", "png"
        ));

        int resultado = buscador.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                File origen = buscador.getSelectedFile();

                File carpeta = new File("img/fotosUsuario");
                if (!carpeta.exists()) carpeta.mkdirs();

                File destino = new File(carpeta, origen.getName());

                java.nio.file.Files.copy(
                        origen.toPath(),
                        destino.toPath(),
                        java.nio.file.StandardCopyOption.REPLACE_EXISTING
                );

                return "img/fotosUsuario/" + origen.getName();

            } catch (IOException e) {
                Metodos.excepcionPantallaEmergente(e.getMessage());

            } catch(ImagenErrorException e){

                Metodos.excepcionPantallaEmergente(e.getMessage());

            }


        }
        return null;

    }


}