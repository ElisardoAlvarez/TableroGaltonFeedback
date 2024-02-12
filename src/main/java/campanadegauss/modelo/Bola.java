package main.java.campanadegauss.modelo;

import java.awt.*;

public class Bola {
    int posicionFinalX;
    int posicionActualY;
    Color color; // Añade un campo para el color de la bola
    boolean haLlegado = false; // Indica si la bola ha llegado a su posición final

    public Bola() {
        this.posicionFinalX = posicionFinalX;
        this.posicionActualY = 0; // Iniciar desde el top del panel
        this.color = Color.RED; // Establece un color por defecto
    }
    public Bola(int posicionFinalX, int posicionActualY, int diametro, Color color) {
        this.posicionFinalX = posicionFinalX;
        this.posicionActualY = posicionActualY;
        this.color = color; // Utiliza el parámetro color
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

    public boolean isHaLlegado() {
        return haLlegado;
    }

    public void setHaLlegado(boolean haLlegado) {
        this.haLlegado = haLlegado;
    }

    public boolean haLlegado() {
    return haLlegado;}

    public Color getColor() {
        return color;
    }

    public int getDiametro() {
        return 0;
    }
}

