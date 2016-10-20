import java.util.*;

public class Main {

    public static void render(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isTree(int[][] matrix, boolean[] marked, int position) {
        marked[position] = true;
        for (int i = 0 ; i < matrix[position].length; i++) {
            if (matrix[position][i] > 0) {
                if (marked[matrix[position][i] - 1] == true) {
                    return false;
                }
                if (isTree(matrix, marked, matrix[position][i] - 1) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();
        int matrix[][] = new int[nodes][nodes]; 
        for (int i = 0; i < edges; i++) {
            int so = s.nextInt();
            int de = s.nextInt();
            matrix[so - 1][de - 1] = de;
        }

        render(matrix);

        boolean marked[] = new boolean[nodes];
        boolean result = isTree(matrix, marked, 0);

        if (result) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
