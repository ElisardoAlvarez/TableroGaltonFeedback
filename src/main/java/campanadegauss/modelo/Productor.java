package main.java.campanadegauss.modelo;


/**
 * Representa una estación de trabajo que produce componentes y los coloca en el búfer compartido.
 */
public class Productor implements Runnable {
    private final BufferCompartido buffer;

    public Productor(BufferCompartido buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                buffer.add(i);
                System.out.println("Produced: " + i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
