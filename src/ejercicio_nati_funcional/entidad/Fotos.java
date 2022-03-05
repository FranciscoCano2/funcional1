package ejercicio_nati_funcional.entidad;

/**
 *
 * @author franc
 */
public class Fotos {

    private String fotosLikes;
    private Long repeticiones;

//constructores
    public Fotos() {
    }

    public Fotos(String fotosLikes, Long repeticiones) {
        this.fotosLikes = fotosLikes;
        this.repeticiones = repeticiones;
    }

//getter
    public String getFotosLikes() {
        return fotosLikes;
    }

    public Long getRepeticiones() {
        return repeticiones;
    }

//setter
    public void setFotosLikes(String fotosLikes) {
        this.fotosLikes = fotosLikes;
    }

    public void setRepeticiones(Long repeticiones) {
        this.repeticiones = repeticiones;
    }

    @Override
    public String toString() {
        return fotosLikes + " = " + repeticiones;
    }

}
