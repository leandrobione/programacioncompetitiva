import java.util.*;

//http://codeforces.com/problemset/problem/337/A
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = scanner.nextInt();
        int puzzles = scanner.nextInt();

        int[] values = new int[puzzles];

        for (int i = 0; i < puzzles; i++ ) {
            int value;
            value = scanner.nextInt();
            values[i] = value;
        }

        Arrays.sort(values);
        for (int i = 0; i < puzzles; i++ ) {
            //System.out.println(values[i]);
        }

        int[][] work = new int[puzzles][students];

        for (int i = 0; i < puzzles; i++ ) {
            for (int j = 0; j < students; j++ ) {
                work[i][j] = 0;
            }
        }

        int diff;
        for (int i = 1; i < puzzles; i++ ) {
            diff = 0;
            for (int j = 1; j < students; j++ ) {
                int x = i - j;

                if (x >= 0) {
                    diff = values[i] - values[x];
                }
                else {
                    diff = work[i][j - 1];
                }

                if (i <= 1) {
                    work[i][j] = diff;
                } else {
                    if (i <= j) {
                        work[i][j] = diff;
                    } else {
                        if (diff <= work[i - 1][j]) {
                            work[i][j] = diff;
                        }
                        else {
                            work[i][j] = work[i -1][j];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < puzzles; i++ ) {
            for (int j = 0; j < students; j++ ) {
  //              System.out.print(work[i][j] +  " ");
            }
//            System.out.println(" ");
        }
        System.out.println(work[puzzles -1][students -1]);
    }

}
