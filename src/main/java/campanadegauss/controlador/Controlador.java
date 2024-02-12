package main.java.campanadegauss.controlador;

import main.java.campanadegauss.modelo.Consumidor;
import main.java.campanadegauss.vista.VentanaPrincipal;
import main.java.campanadegauss.modelo.BufferCompartido;
import main.java.campanadegauss.modelo.Productor;
import main.java.campanadegauss.modelo.Bola;

import java.awt.*;

public class Controlador {
    private VentanaPrincipal vista;
    private BufferCompartido buffer;

    public Controlador() {
        this.buffer = new BufferCompartido(5); // Asumiendo una capacidad de búfer de 5
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        // Inicializar la vista y los productores y consumidores
        this.vista = new VentanaPrincipal();
        Thread productor = new Thread(new Productor(buffer));
        Thread consumidor = new Thread(new Consumidor(buffer));

        productor.start();
        consumidor.start();

        // Crear una bola y verificar que no es null antes de agregarla al VisualizadorDistribucion
        Bola bola = new Bola(0, 0, 20, Color.RED); // Asumiendo estos valores para el constructor de Bola
        if (bola != null) {
            System.out.println(bola);
            vista.getVisualizadorDistribucion().agregarBola(bola);
        }
    }

    public void mostrarVista() {
        vista.setVisible(true);
    }
}
