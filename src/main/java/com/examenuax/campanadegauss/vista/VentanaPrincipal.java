package main.java.com.examenuax.campanadegauss.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Define la ventana principal de la interfaz gráfica para la simulación "Campanas de Gauss".
 * Incluye componentes para controlar y visualizar la simulación de producción y consumo de componentes.
 */
public class VentanaPrincipal extends JFrame {
    // Componentes de la UI
    private JButton btnIniciarSimulacion;
    private JButton btnDetenerSimulacion;
    private JLabel lblEstadoSimulacion;
    private JPanel panelVisualizacion;

    /**
     * Constructor de VentanaPrincipal que inicializa la interfaz de usuario.
     */
    public VentanaPrincipal() {
        inicializarComponentesUI();
    }

    /**
     * Inicializa y organiza los componentes de la interfaz de usuario.
     */
    private void inicializarComponentesUI() {
        setTitle("Campanas de Gauss - Simulación");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de control
        JPanel panelControl = new JPanel();
        btnIniciarSimulacion = new JButton("Iniciar Simulación");
        btnDetenerSimulacion = new JButton("Detener Simulación");
        lblEstadoSimulacion = new JLabel("Estado: Detenido");

        panelControl.add(btnIniciarSimulacion);
        panelControl.add(btnDetenerSimulacion);
        panelControl.add(lblEstadoSimulacion);

        // Panel de visualización
        panelVisualizacion = new JPanel();
        panelVisualizacion.setBackground(Color.WHITE);

        // Añadir paneles al JFrame
        add(panelControl, BorderLayout.NORTH);
        add(panelVisualizacion, BorderLayout.CENTER);

        // Eventos
        btnIniciarSimulacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implementar lógica para iniciar la simulación
                lblEstadoSimulacion.setText("Estado: En ejecución");
            }
        });

        btnDetenerSimulacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implementar lógica para detener la simulación
                lblEstadoSimulacion.setText("Estado: Detenido");
            }
        });
    }
}

