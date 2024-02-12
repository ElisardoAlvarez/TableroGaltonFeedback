package main.java.campanadegauss.modelo;

/**
 * Representa la línea de ensamblaje que consume componentes del búfer compartido.
 */
public class Consumidor implements Runnable {
    private final BufferCompartido buffer;

    public Consumidor(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                int item = buffer.remove();
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
