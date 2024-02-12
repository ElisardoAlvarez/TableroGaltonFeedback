package main.java.campanadegauss.vista;

import java.awt.*;

public class Bola {
    private int diametro = 10;
    private Color color = Color.red;
    int posicionFinalX;
    int posicionActualY;
    boolean haLlegado = false; // Indica si la bola ha llegado a su posición final

    public Bola(int posicionFinalX) {
        this.posicionFinalX = posicionFinalX;
        this.posicionActualY = 0; // Iniciar desde el top del panel
    }
    public Bola(int posicionFinalX, int posicionActualY, int diametro, Color color) {
        this.posicionFinalX = posicionFinalX;
        this.posicionActualY = posicionActualY;
        this.diametro = diametro;
        this.color = color;
    }


    public int getPosicionFinalX() {
        return posicionFinalX;
    }

    public void setPosicionFinalX(int posicionFinalX) {
        this.posicionFinalX = posicionFinalX;
    }

    public int getPosicionActualY() {
        return posicionActualY;
    }

    public void setPosicionActualY(int posicionActualY) {
        this.posicionActualY = posicionActualY;
    }

    public void setHaLlegado(boolean haLlegado) {
        this.haLlegado = haLlegado;
    }

    public boolean haLlegado() {
        return haLlegado;
    }
}

