package ejercicio_nati_funcional.service;

import ejercicio_nati_funcional.entidad.Fotos;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author franc
 */
public class FotosServiceImpl {

    public Fotos CrearFoto(String fotoLikes, Long rep) {
        Fotos photo = new Fotos();

        photo.setFotosLikes(fotoLikes);
        photo.setRepeticiones(rep);

        return photo;
    }

    public List OrdenarLista(List r, int indicador) {
//el indicador nos decidira si ordenamos la lista por likes o por repeticiones
        if (indicador == 0) {
            Collections.sort(r, (Fotos obj1, Fotos obj2) -> obj1.getFotosLikes().compareTo(obj2.getFotosLikes()));
        } else {
            Collections.sort(r, (Fotos obj1, Fotos obj2) -> obj1.getRepeticiones().compareTo(obj2.getRepeticiones()));
        }
        return r;
    }

    public Long Promedio(Fotos lis, int i) {

        Long prom = (i + 1) * lis.getRepeticiones();

        return prom;
    }

}
