package modelo;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private boolean activo;

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.activo = true;
    }

    public void finalizar() {
        if (!activo) throw new IllegalStateException("El préstamo ya está finalizado.");
        this.activo = false;
        this.libro.devolver(); // El libro vuelve a estar disponible
    }

    public boolean estaActivo() { return activo; }
    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }

    @Override
    public String toString() {
        return "Préstamo: " + usuario.getNombre() + " -> " + libro.getTitulo() + (activo ? " (Activo)" : " (Finalizado)");
    }
}
