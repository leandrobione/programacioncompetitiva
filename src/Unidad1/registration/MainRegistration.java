package Unidad1.registration;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jvargas on 9/14/16.
 */
public class MainRegistration {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int cantPalabras = scanner.nextInt();

        ArrayList<Ocurrencias> database = new ArrayList<Ocurrencias>();

        for (int i = 0; i < cantPalabras; i++) {
            String palabra = scanner.next();
            //aba
            Ocurrencias ocurrencias = new Ocurrencias(palabra);
            int index = database.indexOf(ocurrencias);
            if (index != -1){
                database.get(index).contador++;
                System.out.println(palabra+database.get(index).contador);
            } else {
                System.out.println("OK");
                database.add(ocurrencias);
            }

        }
    }
}

class Ocurrencias {
    String palabra;
    int contador;

    public Ocurrencias(String palabra){
        this.palabra = palabra;
        contador = 0;
    }

    @Override
    public boolean equals(Object other){
        Ocurrencias otherOc = (Ocurrencias) other;
        return otherOc.palabra.equalsIgnoreCase(this.palabra);
    }
}
