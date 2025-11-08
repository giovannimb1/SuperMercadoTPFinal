package Codigo.Logica;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OpLectEscrit {

    public static void grabar(String nombreArchivo, JSONArray jarray) {
        try {
            FileWriter fw = new FileWriter(nombreArchivo);
            fw.write(jarray.toString(4));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONTokener leer(String nombreArchivo) {
        JSONTokener token = null;
        try {
            token = new JSONTokener(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return token;
    }
}
