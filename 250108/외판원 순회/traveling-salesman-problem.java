import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] matrix;
    public static boolean[] visitedNord;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        matrix = new int[n][n];
        visitedNord = new boolean[n];

        for (int i = 0; i < n; i++) {
            visitedNord[i] = false;
        }

        visitedNord[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        findMinPath(1, 0, 0);

        System.out.println(min);
    }

    public static void findMinPath(int cnt, int sum, int lastNord) {
        if (cnt == n) {
            min = Math.min(sum + matrix[lastNord][0], min);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visitedNord[i] && matrix[lastNord][i] != 0) {
                visitedNord[i] = true;
                findMinPath(cnt + 1, sum + matrix[lastNord][i], i);
                visitedNord[i] = false;
            }
        }
    }
}