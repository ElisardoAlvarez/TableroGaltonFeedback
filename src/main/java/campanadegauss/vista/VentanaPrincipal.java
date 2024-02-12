package main.java.campanadegauss.vista;

import main.java.campanadegauss.modelo.Bola;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VentanaPrincipal extends JFrame {
    private JButton btnIniciarSimulacion;
    private JButton btnDetenerSimulacion;
    private JLabel lblEstadoSimulacion;
    private VisualizadorDistribucion visualizadorDistribucion;

    public VentanaPrincipal() {
        inicializarComponentesUI();
    }

    private void inicializarComponentesUI() {
        setTitle("Campanas de Gauss - Simulación");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelControl = new JPanel();
        btnIniciarSimulacion = new JButton("Iniciar Simulación");
        btnDetenerSimulacion = new JButton("Detener Simulación");
        lblEstadoSimulacion = new JLabel("Estado: Detenido");

        panelControl.add(btnIniciarSimulacion);
        panelControl.add(btnDetenerSimulacion);
        panelControl.add(lblEstadoSimulacion);

        visualizadorDistribucion = new VisualizadorDistribucion();
        add(panelControl, BorderLayout.NORTH);
        add(visualizadorDistribucion, BorderLayout.CENTER);

        configurarAcciones();
    }

    private void configurarAcciones() {
        btnIniciarSimulacion.addActionListener(e -> iniciarSimulacion());
        btnDetenerSimulacion.addActionListener(e -> detenerSimulacion());
    }

    private void iniciarSimulacion() {
        lblEstadoSimulacion.setText("Estado: En ejecución");
        visualizadorDistribucion.agregarBola(new Bola());
        visualizadorDistribucion.iniciarAnimacion();

        Thread hiloSimulacion = new Thread(() -> {
            java.util.Random random = new java.util.Random();
            for (int i = 0; i < 1000; i++) {
                int posicionFinalX = calcularPosicionFinalX(random);
                main.java.campanadegauss.modelo.Bola bola = new Bola(posicionFinalX, 0, 20, Color.RED);
                SwingUtilities.invokeLater(() -> visualizadorDistribucion.agregarBola(bola));

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            SwingUtilities.invokeLater(() -> lblEstadoSimulacion.setText("Estado: Detenido"));
        });
        hiloSimulacion.start();
    }

    private void detenerSimulacion() {
        visualizadorDistribucion.detenerSimulacion();
    }

    private int calcularPosicionFinalX(Random random) {
        double media = getWidth() / 2.0;
        double desviacionEstandar = 100.0;
        return (int) (random.nextGaussian() * desviacionEstandar + media);
    }

    public VisualizadorDistribucion getVisualizadorDistribucion() {
    return visualizadorDistribucion;
    }
}