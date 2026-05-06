package vista;

import controlador.BibliotecaController;
import modelo.*;
import java.util.List;
import java.util.Scanner;

public class BibliotecaVista {
    private BibliotecaController controlador;
    private Scanner scanner;

    public BibliotecaVista(BibliotecaController controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Registrar Libro");
            System.out.println("2. Registrar Usuario");
            System.out.println("3. Prestar Libro");
            System.out.println("4. Devolver Libro");
            System.out.println("5. Listar Libros");
            System.out.println("6. Listar Prestamos Activos");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: registrarLibro(); break;
                case 2: registrarUsuario(); break;
                case 3: prestarLibro(); break;
                case 4: devolverLibro(); break;
                case 5: listarLibros(); break;
                case 6: listarPrestamosActivos(); break;
                case 7: System.out.println("Adios!"); break;
                default: System.out.println("Opcion invalida");
            }
        } while (opcion != 7);
    }

    private void registrarLibro() {
        System.out.print("Codigo: ");
        String cod = scanner.nextLine();
        System.out.print("Titulo: ");
        String tit = scanner.nextLine();
        System.out.print("Autor: ");
        String aut = scanner.nextLine();
        try {
            controlador.registrarLibro(cod, tit, aut);
            System.out.println("OK");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void registrarUsuario() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nom = scanner.nextLine();
        System.out.print("Correo: ");
        String cor = scanner.nextLine();
        try {
            controlador.registrarUsuario(id, nom, cor);
            System.out.println("OK");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void prestarLibro() {
        System.out.print("Codigo libro: ");
        String cod = scanner.nextLine();
        System.out.print("ID usuario: ");
        String id = scanner.nextLine();
        try {
            controlador.prestarLibro(cod, id);
            System.out.println("Prestamo OK - Devolver en 7 dias");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void devolverLibro() {
        System.out.print("Codigo libro: ");
        String cod = scanner.nextLine();
        try {
            controlador.devolverLibro(cod);
            System.out.println("Devolucion OK");
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarLibros() {
        for (Libro l : controlador.listarLibros()) {
            System.out.println(l);
        }
    }

    private void listarPrestamosActivos() {
        for (Prestamo p : controlador.listarPrestamosActivos()) {
            System.out.println(p);
        }
    }
}