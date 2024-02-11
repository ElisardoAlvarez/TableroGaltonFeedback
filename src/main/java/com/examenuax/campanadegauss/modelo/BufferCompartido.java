package main.java.com.examenuax.campanadegauss.modelo;


import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Representa el búfer compartido utilizado para almacenar y sincronizar la producción y el consumo de componentes.
 */
public class BufferCompartido {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore items;
    private final Semaphore spaces;

    public BufferCompartido(int capacity) {
        this.items = new Semaphore(0);
        this.spaces = new Semaphore(capacity);
    }

    /**
     * Añade un componente al búfer si hay espacio disponible.
     * @param item el componente a añadir.
     * @throws InterruptedException si el hilo es interrumpido.
     */
    public void add(int item) throws InterruptedException {
        spaces.acquire();
        mutex.acquire();
        buffer.add(item);
        mutex.release();
        items.release();
    }

    /**
     * Consume y remueve un componente del búfer si hay alguno disponible.
     * @return el componente consumido.
     * @throws InterruptedException si el hilo es interrumpido.
     */
    public int remove() throws InterruptedException {
        items.acquire();
        mutex.acquire();
        int item = buffer.poll();
        mutex.release();
        spaces.release();
        return item;
    }
}

