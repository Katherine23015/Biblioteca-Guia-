package controlador;

import modelo.*;
import java.util.List;

public class BibliotecaController {
    private Biblioteca biblioteca;

    public BibliotecaController() {
        this.biblioteca = new Biblioteca();
    }

    public void registrarLibro(String codigo, String titulo, String autor) {
        biblioteca.agregarLibro(new Libro(codigo, titulo, autor));
    }

    public void registrarUsuario(String id, String nombre, String correo) {
        biblioteca.agregarUsuario(new Usuario(id, nombre, correo));
    }

    public void prestarLibro(String codigoLibro, String idUsuario) {
        biblioteca.registrarPrestamo(codigoLibro, idUsuario);
    }

    public void devolverLibro(String codigoLibro) {
        biblioteca.devolverLibro(codigoLibro);
    }

    public List<Libro> listarLibros() { return biblioteca.listarLibros(); }
    public List<Usuario> listarUsuarios() { return biblioteca.listarUsuarios(); }
    public List<Prestamo> listarPrestamosActivos() { return biblioteca.listarPrestamosActivos(); }
}
