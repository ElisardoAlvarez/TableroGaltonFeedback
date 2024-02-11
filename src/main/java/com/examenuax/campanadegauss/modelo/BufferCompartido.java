package main.java.com.examenuax.campanadegauss.modelo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Gestiona el búfer compartido entre productores y consumidores, asegurando la sincronización y el acceso seguro.
 */
public class BufferCompartido {
    private final Queue<Integer> buffer = new LinkedList<>();
    private final Semaphore mutex = new Semaphore(1);
    private final Semaphore items;
    private final Semaphore spaces;

    /**
     * Constructor del búfer compartido.
     * @param capacity Capacidad máxima del búfer.
     */
    public BufferCompartido(int capacity) {
        this.items = new Semaphore(0);
        this.spaces = new Semaphore(capacity);
    }

    /**
     * Añade un componente al búfer, asegurando que no se exceda la capacidad.
     * Utiliza semáforos para sincronizar el acceso y garantizar la seguridad entre hilos.
     * @param item El componente a añadir al búfer.
     * @throws InterruptedException Si el hilo actual es interrumpido.
     */
    public void add(int item) throws InterruptedException {
        try {
            spaces.acquire(); // Espera por un espacio disponible.
            mutex.acquire(); // Garantiza el acceso exclusivo al búfer.
            buffer.add(item); // Añade el componente al búfer.
        } finally {
            mutex.release(); // Libera el mutex independientemente de si se produce una excepción o no.
            items.release(); // Indica que hay un nuevo ítem disponible.
        }
    }

    /**
     * Remueve y devuelve un componente del búfer, asegurando que haya elementos disponibles para consumir.
     * Utiliza semáforos para sincronizar el acceso y garantizar la seguridad entre hilos.
     * @return El componente removido del búfer.
     * @throws InterruptedException Si el hilo actual es interrumpido.
     */
    public int remove() throws InterruptedException {
        int item = 0;
        try {
            items.acquire(); // Espera por un ítem disponible.
            mutex.acquire(); // Garantiza el acceso exclusivo al búfer.
            item = buffer.poll(); // Remueve el componente del búfer.
        } finally {
            mutex.release(); // Asegura que el mutex se libera.
            spaces.release(); // Indica que hay un espacio disponible.
        }
        return item;
    }
}
