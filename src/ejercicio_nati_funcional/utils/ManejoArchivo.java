package ejercicio_nati_funcional.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ManejoArchivo {

    /**
     *
     * @author franc
     * @throws java.io.FileNotFoundException
     *
     *
     */
    public final String ruta = "C:\\Users\\franc\\Desktop/likes.txt";

    public ArrayList<String> leerArchivo() throws FileNotFoundException {

        ArrayList<String> listaFotos = new ArrayList();
        BufferedReader br = null;

        try {

            String dato;
            br = new BufferedReader(new FileReader(ruta));
            dato = br.readLine();

            while (dato != null) {

                String[] datoSplit = dato.split(" ");
                Collections.addAll(listaFotos, datoSplit);
                dato = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("error");
        } finally {

            try {
                if (br != null) {
                    br.close();
                }

            } catch (IOException ex) {
                System.out.println("error");
            }
        }
        return listaFotos;
    }

//    public ArrayList<Integer> SacarFotoLista(ArrayList<String> lista) {
//        ArrayList<Integer> LikesFotos = new ArrayList();
//      //  ArrayList<String> PasarNumeros = new ArrayList();
//
//        //Iterator it = listado.iterator();
//        //      while (it.hasNext()) {
//        //Hacemos una variable auxiliar y la obligamos a que sea String (cast)
//        //       String borrar = lista.spliterator("foto");
//        //}
////        while (it.hasNext()) {
////            if (it.next().getRaza().equals(sacar)) { // Borramos 
////                it.remove();
////            }
////        }
//        //lista.stream().forEach((borrar -> borrar.split("foto")), PasarNumeros.add(borrar));
//    //-----------------------------------      ArrayList<String> pasarNumeros = lista.stream().map((borrar -> borrar.split("foto"))).pasarNumeros(Collectors.toList()); 
//  
//        return LikesFotos;
//    }

    public void mostrarLista(List<String> lista) {

        for (String likes : lista) {
            System.out.println(likes);
        }

    }
}
