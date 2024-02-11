package main.java.com.examenuax.campanadegauss.modelo;


/**
 * Representa un componente producido por las estaciones de trabajo.
 * Esta clase podría ampliarse para incluir detalles específicos de cada componente.
 */
public class Componente {
    private int id;

    public Componente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
