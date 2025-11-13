package Logica;

public class AutenticacionException extends Exception {

    public AutenticacionException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return "Hubo un error al autenticar al usuario: "+super.getMessage();
    }
}
