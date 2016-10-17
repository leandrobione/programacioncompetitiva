import java.util.*;

class Bloque implements Comparable<Bloque> {
    public int d = 0;
    public int w = 0;
    
    public int compareTo(Bloque o) {            
        if (this.d < o.d) {
            return 1;
        }
        
        if (this.d == o.d) {
            if (this.w < o.w) {
                return 1;
            }
            if (this.w == o.w) {
                return 0;
            }
            else {
                return -1;
            }
        }

        return -1;
    }
}



//https://omegaup.com/arena/problem/altas#problems
public class Main {
    
    public static void render(Vector<Bloque> v) {
        System.out.println("===");
        for (int i = 0; i < v.size(); i++) {           
            System.out.println(v.elementAt(i).d + " " + v.elementAt(i).w);
        }
        System.out.println("===");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bloques = scanner.nextInt();     
        
        if (bloques == 1 ){
            System.out.println(1); System.exit(0);
        }
        
        Vector<Bloque> v = new Vector<Bloque>();

        for (int i = 0; i < bloques; i++ ) {
            Bloque p = new Bloque();
            p.d = scanner.nextInt();
            p.w = scanner.nextInt();                    
            v.add(p);
        }
                      
        Collections.sort(v);
        
        //render(v);
        
        int[] sizes = new int[bloques];
        
        for (int i = 0; i < bloques; i++) {             
            sizes[i] = 1;
        }                        
        
        for (int i = 1; i < bloques; i++) {                         
            for (int j = 0; j < i; j++) {     
                if (v.elementAt(i).d < v.elementAt(j).d 
                    && v.elementAt(i).w < v.elementAt(j).w
                    && sizes[i] < sizes[j] + 1) 
                {                    
                    sizes[i] = sizes[i] + 1;                    
                }                        
            }
        }             
         
        int max = -1;
        for (int i = 0; i < bloques; i++) {             
            if (sizes[i] > max) {
                max = sizes[i];
            }
        }
        
        System.out.println(max);            
    }

}