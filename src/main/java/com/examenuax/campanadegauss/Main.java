package main.java.com.examenuax.campanadegauss;

import main.java.com.examenuax.campanadegauss.controlador.Controlador;

/**
 * Punto de entrada principal para la simulación de la fábrica "Campanas de Gauss" siguiendo el patrón MVC.
 */
public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.mostrarVista();
    }
}
