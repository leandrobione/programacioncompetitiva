import java.util.*;

//http://www.spoj.com/problems/PT07Z/
public class Main {

    public static void renderVector(Vector<Vector<Integer>> v) {
        for (int i = 0; i < v.size(); i++) {
            Vector<Integer> sv = v.get(i);
            for (int j = 0; j < sv.size(); j++) {
                System.out.print(sv.get(j));
            }
            System.out.println();
        }
    }

    public static int deepth(Vector<Vector<Integer>> v, boolean[] marked, int position, int parent, int size) {    
        marked[position] = true;
        Vector<Integer> sv = v.get(position);
        int initial_size = size;

        for (int i = 0; i < sv.size(); i++) {
            if (marked[sv.get(i)] == true && sv.get(i) != parent) {
                return size;
            }

            int temp_size = deepth(v, marked, sv.get(i), i, initial_size + 1);
            if (temp_size > size) {
                size = temp_size;
            }
        } 

        return size;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();

        Vector<Vector<Integer>> vnodes = new Vector<Vector<Integer>>(1);

        for (int i = 0; i < nodes; i++) {
            vnodes.addElement(new Vector<Integer>(1));
        }

        for (int i = 0; i < nodes - 1; i++) {
            int so = s.nextInt();
            int de = s.nextInt();
            if (so <= de) {
                Vector<Integer> v = vnodes.get(so - 1);
                v.addElement(de - 1);
            } else {
                Vector<Integer> v = vnodes.get(de - 1);
                v.addElement(so - 1);
            }
        }

        boolean marked[] = new boolean[nodes];
        int length = deepth(vnodes, marked, 0, 0, 0);

        boolean all_visited = true;
        for (int i = 0; i < nodes; i++) {
            if (marked[i] == false) {
                all_visited = false;
            }
        }

        if (all_visited) {
            System.out.println(length);
        }
        else {
            System.out.println(length);
        }
    }
}
