package com.bieitosousa.pmdm02;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {
/*
 un número primo es un número natural mayor que 1
 que tiene únicamente dos divisores positivos distintos:
  él mismo y el 1
 */
    private static List<Integer> nPrimoList= new ArrayList<Integer>();
    private static boolean esPrimo(int numero){
        // si el numero es 1 ó 0 es primo
        if (numero  == 0 || numero == 1){
            return true;
        }
        // comenzamos en el numero posterior al 1 --> 2
        int contador = 2;
        boolean primo=true;
        // si el numero divido entre el rango [2 -> numero -1]  no tiene division entera es primo.
        while ( contador!=numero){
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
    public static Integer numberOfPrimoInt(int number){
        /*
            #   Para obtener el ultimo numero , a la lista.sinze() hay que restar 1
            -->     index 0.. ; size() 1....
            -->     nPrimoList.get(nPrimoList.size()-1);
            #   Para llegar al numero que pedimos en :  bucles , o en comparaciones
            -->     es necesario restar 1 a List.size() puesto que esto da error en el caso [-1]
            -->     sumamos +1 al numero input.
            --<     Esto genera un proble para aceder a la posicion 0
            -->     en el caso que queramos ver la posicion 0, Habria que contemplarlo en un IF
            -->     pero entendemos que se van a pedir posiciones 1,....
         */
        try{
            if(nPrimoList.size()>= number+1){     // si ya lo tenemos en memoria
                return nPrimoList.get(number);
            }else {                             // si no lo tenemos en memoria
                int startIndex = 1;             //x defecto partimos del inicio [ 0 no es natural]
                if (nPrimoList.size() != 0) {   // si tenemos  nº memoria , partimos de la misma
                    startIndex = nPrimoList.get(nPrimoList.size()-1)+1; //comenzamos en el ultimo numero +1
                }
                int greater = 1000000;          // limite superior
                int less = 0;                    // limite inferior
                if (number < less && number > greater) {
                    throw new Exception(
                            "The number must be greater than"
                                    + greater
                                    + " and less than" + less);
                }
                while (nPrimoList.size() != number+1) {
                    if (esPrimo(startIndex)) {
                        nPrimoList.add(startIndex);
                    }
                    startIndex++;
                }
                // devolvemos el ultimo numero primo (Posicion comienza en 0 , y size en 1)
               return nPrimoList.get(nPrimoList.size()-1);
            }
        }catch(Exception e ){
            System.err.println(e.getMessage());
        }
        return null;
    }
    /*
    public static int CribaEratostenes(int number){
        int init = 2;
        int fin = 10000
        try{

            List<Integer> nPrimoList= new ArrayList<Integer>();
            // entendiendo que el 0 no es un numero natural
            // comenzamos en el 1.
            int startIndex = 1;
            int greater = 1000000;
            int less = 0;
            if (number < less && number > greater){
                throw new Exception(
                        "The number must be greater than"
                                + greater
                                + " and less than" +less );
            }
            while (nPrimoList.size() != number){
                if (esPrimo(startIndex)) {
                    nPrimoList.add(startIndex);
                }
                startIndex++;
            }
            // devolvemos el ultimo numero primo (Posicion comienza en 0 , y size en 1)
            res = nPrimoList.get(nPrimoList.size()-1);
            return res;
        }catch(Exception e ){
            System.err.println(e.getMessage());
        }
        return res;
    }
    */

}
