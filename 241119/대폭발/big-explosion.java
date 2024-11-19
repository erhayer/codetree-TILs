import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] mat;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        mat = new int[n][n];

        bomb(r, c, 0);

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) count++;
            }
        }

        System.out.println(count);

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < n; i++) {
        //    for (int j = 0; j < n; j++) {
        //        sb.append(0 + mat[i][j]).append(" ");
        //    }

        //    sb.append("\n");
        // }

        // System.out.println(sb);
    }

    public static void bomb(int r, int c, int t) {
        if (inRange(r, c) && t <= m) {
            mat[r][c] = 1;

            for (int i = t; i < m; i++) {
                bomb(r - exp(i), c, i+1);
                bomb(r, c + exp(i), i+1);
                bomb(r + exp(i), c, i+1);
                bomb(r, c - exp(i), i+1);
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static int exp(int n) {
        int product = 1;

        for (int i = 0; i < n; i++) {
            product *= 2;
        }

        return product;
    }
}