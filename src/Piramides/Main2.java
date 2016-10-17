import java.util.*;

//https://omegaup.com/arena/problem/simbolos#problems
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piramides = scanner.nextInt();     
        int[] h = new int[piramides];
        int[] r = new int[piramides];
        int max_h = 0;
        int max_r = 0;
        int max_i = 0;

        for (int i = 0; i < piramides; i++ ) {
            h[i] = scanner.nextInt();
            r[i] = scanner.nextInt();

            if (max_h < h[i]) {
                max_h = h[i];
            }

            if (max_r < r[i]) {
                max_r = r[i];
                max_i = i;
            }
        }

        String out = "";
        for (int current = 0; current < piramides; current++ ) {                                    
            int mejor = r[current];
            int top_izq = 0;
            int top_der = 0;

            if (max_i == current) {
                mejor = max_r;
            }

            for (int diff = 1; diff < piramides; diff++) {
                if (mejor == max_r) {
                    diff = piramides + 10;
                    continue;
                }

                int idx_izq = current - diff;
                int idx_der = current + diff;

                if (idx_izq >= 0 && top_izq == 0) {
                    if (r[idx_izq] > mejor) {
                        mejor = r[idx_izq];
                    }
                    
                    if (h[idx_izq] > h[current]) {
                        top_izq = 1;
                    }
                }
                
                if (idx_der < piramides && top_der == 0) {
                    if (r[idx_der] > mejor) {
                        mejor = r[idx_der];
                    }
                    
                    if (h[idx_der] > h[current]) {
                        top_der = 1;
                    }
                }   
            }
            out += mejor + " ";
        }
        System.out.println(out.trim());                
    }        
}
