import controlador.BibliotecaController;
import vista.BibliotecaVista;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controlador = new BibliotecaController();
        BibliotecaVista vista = new BibliotecaVista(controlador);
        vista.mostrarMenu();
    }
}