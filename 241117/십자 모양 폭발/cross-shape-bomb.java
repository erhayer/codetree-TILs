import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] mat;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt();
        int c = sc.nextInt();

        explode(r-1, c-1);
        gravitate();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void explode(int r, int c) {
        int scale = mat[r][c] - 1;

        for (int i = c - scale; i <= c + scale; i++) {
            if (inRange(r, i)) {
                mat[r][i] = 0;
            }
        }

        for (int i = r - scale; i <= r + scale; i++) {
            if (inRange(i, c)) {
                mat[i][c] = 0;
            }
        }
    }

    public static void gravitate() {
        int[] temp;
        for (int i = 0; i < n; i++) {
            temp = new int[n];
            int index = n-1;

            for (int j = n-1; j >= 0; j--) {
                if (mat[j][i] != 0) {
                    temp[index--] = mat[j][i];
                }
            }

            for (int j = 0; j < n; j++) {
                mat[j][i] = 0 + temp[j];
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >=0 && c < n;
    }
}