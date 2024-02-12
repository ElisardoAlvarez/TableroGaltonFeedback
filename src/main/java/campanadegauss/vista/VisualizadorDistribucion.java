package main.java.campanadegauss.vista;

import main.java.campanadegauss.modelo.Bola;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa el visualizador de la distribución de las bolas.
 */
public class VisualizadorDistribucion extends JPanel {
    private List<main.java.campanadegauss.modelo.Bola> bolas = new ArrayList<>();
    private Timer animacionTimer;
    private final int DIAMETRO_BOLA = 6;

    /**
     * Constructor de la clase.
     * Establece el color de fondo e inicia la animación.
     */
    public VisualizadorDistribucion() {
        setBackground(Color.WHITE);
    }

    /**
     * Inicia la animación.
     * Crea un Timer que actualiza las posiciones de las bolas y repinta el panel cada 16 milisegundos.
     */
    public void iniciarAnimacion() {
        if (animacionTimer != null) {
            animacionTimer.stop(); // Detiene el Timer actual si existe
        }
        animacionTimer = new Timer(16, e -> {
            actualizarPosiciones();
            repaint();
        });
        animacionTimer.start(); // Inicia un nuevo Timer
    }

    /**
     * Actualiza las posiciones de las bolas.
     * Si una bola aún no ha llegado a su posición final, incrementa su posición Y.
     * Si todas las bolas han llegado a su posición final, detiene la simulación.
     */
    private void actualizarPosiciones() {
        for (main.java.campanadegauss.modelo.Bola bola : bolas) {
            if (!bola.haLlegado()) {
                int nuevaPosY = bola.getPosicionActualY() + 5;
                bola.setPosicionActualY(nuevaPosY);
                if (nuevaPosY >= calcularPosicionFinalY() || hayColision(bola)) {
                    bola.setHaLlegado(true);
                }
            }
        }
        if (bolas.stream().allMatch(main.java.campanadegauss.modelo.Bola::haLlegado)) {
            detenerSimulacion();
        }
    }

    private boolean hayColision(main.java.campanadegauss.modelo.Bola bola) {
        for (main.java.campanadegauss.modelo.Bola otraBola : bolas) {
            if (otraBola != bola && otraBola.haLlegado()) {
                int dx = otraBola.getPosicionFinalX() - bola.getPosicionFinalX();
                int dy = otraBola.getPosicionActualY() - bola.getPosicionActualY();
                int distancia = (int) Math.sqrt(dx * dx + dy * dy);

                if (distancia < DIAMETRO_BOLA) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Detiene la simulación.
     * Detiene el Timer de la animación.
     */
    public void detenerSimulacion() {
        animacionTimer.stop();
    }

    /**
     * Agrega una bola a la lista de bolas y repinta el panel.
     * @param bola La bola a agregar.
     */
    public void agregarBola(main.java.campanadegauss.modelo.Bola bola) {
        bolas.add(bola);
        repaint();

    }

    /**
     * Dibuja las bolas en el panel.
     * @param g El objeto Graphics para dibujar en el panel.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Bola bola : bolas) {
            g.setColor(bola.getColor()); // Establece el color de la bola
            g.fillOval(bola.getPosicionFinalX(), bola.getPosicionActualY(), DIAMETRO_BOLA, DIAMETRO_BOLA);
        }
    }

    /**
     * Calcula la posición final Y de las bolas.
     * @return La posición final Y.
     */
    private int calcularPosicionFinalY() {
        return getHeight() - 50;
    }

    /**
     * Calcula la posición final X de las bolas.
     * @return La posición final X.
     */
    private int calcularPosicionFinalX(){
        Random random = new Random();
        double media = getWidth() / 2.0;
        double desviacionEstandar = 100.0;
        int posicionFinalX = (int) (random.nextGaussian() * desviacionEstandar + media);
        // Limita la posición final X al ancho del panel
        posicionFinalX = Math.max(posicionFinalX, 0);
        posicionFinalX = Math.min(posicionFinalX, getWidth() - DIAMETRO_BOLA);
        return posicionFinalX;
    }
}