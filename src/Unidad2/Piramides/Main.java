/**

Pirámides Relevantes

Hay N pirámides alineadas en línea recta.
Las pirámides estan numeradas de 1 a N, de izquierda a derecha.
Cada pirámide i tiene un nivel de relevancia Ri y tambien tiene una altura Hi.

Desde la parte mas alta de cualquiera de las pirámides, es posible ver todas las pirámides hacia la izquierda o hacia la derecha, siempre y cuando cuando no exista una piramide mas alta que obstruya la vista.

Es decir, una pirámide j se puede ver desde la parte mas alta de una pirámide i, sí y solo sí NO existe alguna k tal que i < k < j ó j < k < i para Hk ≥ Hi.

Por ejemplo, si hay 6 pirámides con alturas 1, 3, 2, 1, 5, 2(de izquierda a derecha en ese orden) desde la parte mas alta de la pirámide 3(que tiene altura 2), se pueden ver las pirámides 2, 3, y 4 y 5 y las pirámides 1 y 6 no pueden ser vistas desde ahí ya que las pirámides 2(de altura 3) y 5(de altura 5) obstruyen la vista. 

En cambio, desde la parte mas alta de la pirámide 5 se pueden ver todas las pirámides, mientras que desde la parte mas alta de la pirámide 6, solamente se puede ver la pirámide 5.

Un guía de turistas ha pedido tu ayuda.

Problema

Escribe un programa que dadas las características de las pirámides, de- termine, para la parte mas alta de cada pirámide, cual es la pirámide mas importante que puede ser vista desde ahí.

Entrada
Línea 1: Un solo número entero N.
Siguientes N líneas: La línea i + 1 contiene los dos enteros Hi y Ri separados por un espacio.

Salida
N números enteros, donde el i−ésimo entero representa la relevancia de la pirámide mas relevante que se pueda ver desde la parte mas alta de la pirámide i.


Entrada de Ejemplo
6
1 10 35 24 13 51 22

Salida de Ejemplo 10 10 5 4 10 2

Consideraciones

Puedes asumir que 2 ≤N≤ 1000000.

**/

import java.util.*;

class Piramide {
    public int h;
    public int r;    
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piramides = scanner.nextInt();     
        Vector<Piramide> v = new Vector<Piramide>();
        Vector<Piramide> salida = new Vector<Piramide>();
    
        
        for (int i = 0; i < piramides; i++ ) {
            Piramide p = new Piramide();
            p.h = scanner.nextInt();
            p.r = scanner.nextInt();                    
            v.add(p);
        }
        
        String out = "";
        for (int current = 0; current < piramides; current++ ) {                                    
            int mejor = v.elementAt(current).r;            
            
            for (int izq = current - 1; izq >= 0; izq --) {
                if (v.elementAt(izq).h < v.elementAt(current).h) {
                    if (v.elementAt(izq).r > mejor) {
                        mejor = v.elementAt(izq).r;
                    }
                }
                else {
                    if (v.elementAt(izq).r > mejor) {
                        mejor = v.elementAt(izq).r;
                    }
                    izq = -1;
                }
                
            }
            
            for (int der = current + 1; der < piramides; der ++) {
                if (v.elementAt(der).h < v.elementAt(current).h) {
                    if (v.elementAt(der).r > mejor) {
                        mejor = v.elementAt(der).r;
                    }
                }
                else {
                    if (v.elementAt(der).r > mejor) {
                        mejor = v.elementAt(der).r;
                    }
                    der = piramides + 10;
                }
            }                             
            
            out += mejor + " ";            
        }
        
        System.out.println(out.trim());                
    }        
}