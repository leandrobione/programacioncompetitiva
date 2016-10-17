import java.util.*;

class Piramide {
    public int h;
    public int r;
    public int pos;
}

//https://omegaup.com/arena/problem/simbolos#problems
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piramides = scanner.nextInt();     
        Vector<Piramide> v = new Vector<Piramide>();
        Vector<Piramide> salida = new Vector<Piramide>();

        int max_h = 0;
        int max_r = 0;
        int max_i = 0;

        for (int i = 0; i < piramides; i++ ) {
            Piramide p = new Piramide();
            p.h = scanner.nextInt();
            p.r = scanner.nextInt();

            if (max_h < p.h) {
                max_h = p.h;
            }

            if (max_r < p.r) {
                max_r = p.r;
                max_i = i;
            }

            p.pos = i;
            v.add(p);
        }

        String out = "";
        for (int current = 0; current < piramides; current++ ) {                                    
            int mejor = v.elementAt(current).r;
            int top_izq = 0;
            int top_der = 0;

            for (int diff = 1; diff < piramides; diff++) {

                if (mejor == max_r) {
                    diff = piramides + 10;
                    continue;
                }

                int idx_izq = current - diff;
                int idx_der = current + diff;

                if (idx_izq >= 0 && top_izq == 0) {
                    if (v.elementAt(idx_izq).r > mejor) {
                        mejor = v.elementAt(idx_izq).r;
                    }
                    
                    if (v.elementAt(idx_izq).h > v.elementAt(current).h) {
                        top_izq = 1;
                    }
                }
                
                if (idx_der < piramides && top_der == 0) {
                    if (v.elementAt(idx_der).r > mejor) {
                        mejor = v.elementAt(idx_der).r;
                    }
                    
                    if (v.elementAt(idx_der).h > v.elementAt(current).h) {
                        top_der = 1;
                    }
                }
            
            }

            out += mejor + " ";            
        }

        System.out.println(out.trim());                
    }        
}
