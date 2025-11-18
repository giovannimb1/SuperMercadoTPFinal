package Codigo.Interfaz.ClasesAux;

public class ImagenErrorException extends RuntimeException {
    public ImagenErrorException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Hubo un error con su imagen : "+super.getMessage();
    }
}
