package modelo;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean estaDisponible() { return disponible; }

    public void prestar() {
        if (!disponible) throw new IllegalStateException("El libro no está disponible.");
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return codigo + " - " + titulo + " por " + autor + " (" + (disponible ? "Disponible" : "Prestado") + ")";
    }
}
