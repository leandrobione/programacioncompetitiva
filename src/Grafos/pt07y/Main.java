import java.util.*;

//http://www.spoj.com/problems/PT07Y/
public class Main {

    public static void render(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    


    public static void renderVector(Vector<Vector<Integer>> v) {
        for (int i = 0; i < v.size(); i++) {
            Vector<Integer> sv = v.get(i);
            for (int j = 0; j < sv.size(); j++) {
                System.out.print(sv.get(j));
            }
            System.out.println();
        }
    }

    public static boolean isTree(Vector<Vector<Integer>> v, boolean[] marked, int position, int parent) {    
        marked[position] = true;
        Vector<Integer> sv = v.get(position);
        for (int i = 0; i < sv.size(); i++) {
            if (marked[sv.get(i)] == true && sv.get(i) != parent) {
                return false;
            }

            if (isTree(v, marked, sv.get(i), i) == false) {
                return false;
            }
        } 
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();

        Vector<Vector<Integer>> vnodes = new Vector<Vector<Integer>>(1);

        for (int i = 0; i < nodes; i++) {
            vnodes.addElement(new Vector<Integer>(1));
        }

        for (int i = 0; i < edges; i++) {
            int so = s.nextInt();
            int de = s.nextInt();
            Vector<Integer> v = vnodes.get(so - 1);
            v.addElement(de - 1);
        }

        //renderVector(vnodes);

        boolean marked[] = new boolean[nodes];
        boolean result = isTree(vnodes, marked, 0, 0);

        boolean all_visited = true; 
        for (int i = 0; i < nodes; i++) {
            if (marked[i] == false) {
                all_visited = false;
            }
        }

        if (all_visited && result) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
