package Codigo.Logica;

public interface IGestor<T> {

      String agregar(T obj);
      String eliminar(int id);
      String modificar(int id, T obj);
      void listar();
}
