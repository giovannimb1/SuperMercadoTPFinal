package Codigo.Logica;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Usuario implements Comparable<Usuario> {

    /// ATRIBUTOS
    protected int id;
    private static int cont = 1;
    protected String nombre;
    protected String apellido;
    protected String username;
    protected String email;
    protected String password;
    protected LocalDate fechaRegistro;
    protected boolean permisos;

    /// CONSTRUCTORES  (los 2 constructores se aseguran q se inicien con id y fecha de registro)
    public Usuario(String nombre, String apellido, String username, String email, String password) {
        this.id = cont++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.email = email;
        this.password = password;
        this.fechaRegistro = LocalDate.now();
    }

    public Usuario() {
        this.id = cont++;
        this.fechaRegistro = LocalDate.now();
    }

    /// GETTERS AND SETTERS
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isPermisos() {
        return permisos;
    }

    public void setPermisos(boolean permisos) {
        this.permisos = permisos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Usuario.cont = cont;
    }

    /// METODOS
    @Override
    public String toString() {
        return "|------------------------------------------------|\n" +
                "| [USUARIO]  ID: " + id + "\n" +
                "|------------------------------------------------|\n" +
                "|  Nombre: " + nombre + "\n" +
                "|  Apellido: " + apellido + "\n" +
                "|  Email: $" + email + "\n" +
                "|  Contraseña: " + password + "\n" +
                "|  Fecha Registro: " + fechaRegistro + "\n" +
                "|  Admin: " + permisos + "\n" +
                "|------------------------------------------------|";

    }

    // este equals hace que un usuario sea considerado igual a otro si tienen mismo id
    // O mismo email O mismo usuario
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario u)) return false;
        return id == u.id ||
                Objects.equals(username, u.username) ||
                Objects.equals(email, u.email);
    }

    @Override
    public int hashCode() {
        return 0;  // esto es para q pase de una a comparar por equals
    }

    // esto era por si lo usabamos mas adelante
    @Override
    public int compareTo(Usuario aux) {
        return this.fechaRegistro.compareTo(aux.getFechaRegistro());
    }
}
