package main.java.com.examenuax.campanadegauss.controlador;


import main.java.com.examenuax.campanadegauss.modelo.BufferCompartido;
import main.java.com.examenuax.campanadegauss.modelo.Consumidor;
import main.java.com.examenuax.campanadegauss.modelo.Productor;
import main.java.com.examenuax.campanadegauss.vista.VentanaPrincipal;

/**
 * Controlador que gestiona la interacción entre la vista y el modelo en la simulación de Campanas de Gauss.
 */
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
    }

    public void mostrarVista() {
        vista.setVisible(true);
    }
}
