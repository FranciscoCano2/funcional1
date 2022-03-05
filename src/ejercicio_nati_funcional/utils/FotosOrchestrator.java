package ejercicio_nati_funcional.utils;

import ejercicio_nati_funcional.entidad.Fotos;
import ejercicio_nati_funcional.service.FotosServiceImpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 *
 * @author franc
 */
public class FotosOrchestrator {

    public void FotosOrchestrator() throws FileNotFoundException {

        ManejoArchivo leer = new ManejoArchivo();
        FotosServiceImpl service = new FotosServiceImpl();
        List<Fotos> fotoLikes = new ArrayList();
        long minimo, maximo, promedio = 0;
        String fotosminima, fotosmaxima;
        int i = 0;

//arma un mapa con las fotos y sus repeticiones
        Map<String, Long> counting = leer.leerArchivo().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//armo el objeto foto
        for (Map.Entry<String, Long> entry : counting.entrySet()) {
            Fotos ph = service.CrearFoto(entry.getKey(), entry.getValue());
            fotoLikes.add(ph);
        }

//ordeno por repeticiones
        fotoLikes = service.OrdenarLista(fotoLikes, 1);

//minimo 
        minimo = fotoLikes.get(0).getRepeticiones();
        fotosminima = fotoLikes.get(0).getFotosLikes();

//max
        maximo = fotoLikes.get(fotoLikes.size() - 1).getRepeticiones();
        fotosmaxima = fotoLikes.get(fotoLikes.size() - 1).getFotosLikes();

//ordeno por likes
        fotoLikes = service.OrdenarLista(fotoLikes, 0);
        fotoLikes.stream().forEach(System.out::println);
//promedio
        for (Fotos ph : fotoLikes) {
            promedio += fotoLikes.get(i).getRepeticiones();
            i++;
        }
        promedio = promedio / fotoLikes.size();

        System.out.println("La minima cantidad de likes repetidos es " + minimo + " y son "+ fotosminima);
        System.out.println("La maxima cantidad de likes repetidos es " + maximo + " y son "+ fotosmaxima);
        System.out.println("La cantidad promedio de likes repetidos es " + promedio);
   

//        fotoLikes.stream().forEach(System.out::println);
    }
}
