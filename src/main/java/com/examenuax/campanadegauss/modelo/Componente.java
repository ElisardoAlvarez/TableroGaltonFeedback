package main.java.com.examenuax.campanadegauss.modelo;


/**
 * Representa un componente producido en la fábrica "Campanas de Gauss".
 * Este componente es el elemento básico que se produce y se consume en la simulación.
 */
public class Componente {
    private int id; // Identificador único del componente
    private String tipo; // Tipo del componente, para diferenciar entre distintos componentes producidos
    private long timestampProduccion; // Marca de tiempo de cuando se produjo el componente

    /**
     * Constructor para crear un nuevo componente.
     * @param id Identificador único del componente.
     * @param tipo Tipo del componente.
     */
    public Componente(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.timestampProduccion = System.currentTimeMillis(); // Captura el momento de la creación del componente
    }

    /**
     * Obtiene el identificador del componente.
     * @return el identificador del componente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador del componente.
     * @param id el nuevo identificador para el componente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el tipo del componente.
     * @return el tipo del componente.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo del componente.
     * @param tipo el nuevo tipo del componente.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la marca de tiempo de producción del componente.
     * @return la marca de tiempo de cuando se produjo el componente.
     */
    public long getTimestampProduccion() {
        return timestampProduccion;
    }

    /**
     * Representación en cadena del componente que incluye su id, tipo y timestamp de producción.
     * @return una cadena que representa al componente.
     */
    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", tipo='" + tipo + ' '+
        ", timestampProduccion=" + timestampProduccion +
                '}';
    }
}
