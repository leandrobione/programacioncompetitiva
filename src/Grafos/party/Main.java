import java.util.*;

//http://codeforces.com/problemset/problem/115/A

public class Main {

    static int n; //Numero de Nodos
    static List<Integer> g[]; //Aca guardamos el Grafo
    static int[] d; //Aca los niveles que vamos acumulando, por cada nodo sabremos que tan profundo esta
    static boolean[] root; //Arreglo con los nodos roots, puede haber varios
    
    public static void bfs(int s) {
        d[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (int to: g[v]) {
                if (d[to] > d[v] + 1) {
                    d[to] = d[v] + 1;
                    q.add(to);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        
        root = new boolean[n + 1];
        g = new ArrayList[n + 1];
        d = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>(); //Inicializamos la lista de adyacencia del grafo
            d[i] = Integer.MAX_VALUE; //Inicializamos el acumulador con Max Values
        }

        //Armamos el grafo desde la entrada
        for (int i = 1; i <= n; i++) {
            int v = in.nextInt();
            if (v == -1) { //Si es root lo ponemos en la lista de roots y no sera adyacente de nadie asi que continuamos
                root[i] = true;
                continue;
            }
            g[v].add(i); //Si no es root es adyacente quien indica la entrada, lo anadimos a la lista
        }

        //Buscamos en todos los roots con bfs.
        for (int i = 1; i <= n; i++) {
            if (root[i]) {
                bfs(i);
            }
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) { //Buscamos en la lista de los acumulados el valor maximo obtenido.
            if (d[i] == Integer.MAX_VALUE) {
                continue;
            }
            ans = Math.max(ans, d[i]);
        }

        System.out.println(ans + 1); //Sumamos mas uno para saber cuantos grupos finales quedan
    }
}
