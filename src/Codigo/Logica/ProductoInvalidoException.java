package Codigo.Logica;

public class ProductoInvalidoException extends Exception {

    public ProductoInvalidoException(String message) {
        super(message);
    }

    @Override
    public String getMessage(){
        return "Hubo un error al crear el producto: "+super.getMessage();
    }
}
