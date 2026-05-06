package modelo;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();
    public void agregarLibro(Libro libro) {
        if (buscarLibroPorCodigo(libro.getCodigo()) != null)
            throw new IllegalArgumentException("Ya existe un libro con ese código.");
        libros.add(libro);
    }

    public Libro buscarLibroPorCodigo(String codigo) {
        for (Libro l : libros)
            if (l.getCodigo().equals(codigo)) return l;
        return null;
    }

    public List<Libro> listarLibros() { return new ArrayList<>(libros); }

    public void agregarUsuario(Usuario usuario) {
        if (buscarUsuarioPorId(usuario.getId()) != null)
            throw new IllegalArgumentException("Ya existe un usuario con ese ID.");
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios)
            if (u.getId().equals(id)) return u;
        return null;
    }

    public List<Usuario> listarUsuarios() { return new ArrayList<>(usuarios); }

    public void registrarPrestamo(String codigoLibro, String idUsuario) {
        Libro libro = buscarLibroPorCodigo(codigoLibro);
        Usuario usuario = buscarUsuarioPorId(idUsuario);

        if (libro == null) throw new IllegalArgumentException("Libro no existe.");
        if (usuario == null) throw new IllegalArgumentException("Usuario no existe.");
        if (!libro.estaDisponible()) throw new IllegalStateException("Libro no disponible.");

        libro.prestar();
        Prestamo prestamo = new Prestamo(usuario, libro);
        prestamos.add(prestamo);
    }

    public void devolverLibro(String codigoLibro) {
        for (Prestamo p : prestamos) {
            if (p.getLibro().getCodigo().equals(codigoLibro) && p.estaActivo()) {
                p.finalizar();
                return;
            }
        }
        throw new IllegalStateException("No hay un préstamo activo para ese libro.");
    }

    public List<Prestamo> listarPrestamosActivos() {
        List<Prestamo> activos = new ArrayList<>();
        for (Prestamo p : prestamos)
            if (p.estaActivo()) activos.add(p);
        return activos;
    }
}
