import java.util.*;

//http://www.spoj.com/problems/PT07Z/
public class Main {

    static int total = 0;

    public static void renderVector(Vector<Vector<Integer>> v) {
        for (int i = 0; i < v.size(); i++) {
            Vector<Integer> sv = v.get(i);
            for (int j = 0; j < sv.size(); j++) {
                System.out.print(sv.get(j));
            }
            System.out.println();
        }
    }

    public static int deepth(Vector<Vector<Integer>> v, boolean[] marked, int position) {    
        marked[position] = true;
        Vector<Integer> sv = v.get(position);
        int m;
        int m1 = -1;
        int m2 = -1;

        for (int i = 0; i < sv.size(); i++) {
            if (marked[sv.get(i)] == false) {
           
                m = deepth(v, marked, sv.get(i));
                if (m >= m1) {
                    m2 = m1;
                    m1 = m;
                }
                else if (m > m2) {
                    m2 = m;
                }
            }
        } 

        total = Math.max(total, m1 + m2 + 2);
        return (m1 + 1);
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
        int length = deepth(vnodes, marked, 0);
        System.out.println(total);
    }
}
