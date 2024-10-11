import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = -1;
            }
        }

        int r = n/2, c = n/2, dir = 3;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        int num = 1;
        int tr, tc;
        for (int i = 0; i < n*n; i++){
            mat[r][c] = num++;

            tr = r + dr[(dir + 1) % 4];
            tc = c + dc[(dir + 1) % 4];
            if (num != 2 && mat[tr][tc] == -1) {
                dir = (dir + 1) % 4;
            }
            r += dr[dir];
            c += dc[dir];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}