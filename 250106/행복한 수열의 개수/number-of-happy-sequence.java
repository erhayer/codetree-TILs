import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            //find happy row

            int currR = -1;
            int cntR = 0;

            for (int j = 0; j < n; j++) {
                int r = grid[i][j];

                if (r == currR) {
                    cntR++;
                } else {
                    currR = r;
                    cntR = 1;
                }

                if (cntR >= m) {
                    cnt++;
                    break;
                }
            }

            //find happy col

            int currC = -1;
            int cntC = 0;

            for (int j = 0; j < n; j++) {
                int c = grid[j][i];

                if (c == currC) {
                    cntC++;
                } else {
                    currC = c;
                    cntC = 1;
                }

                if (cntC >= m) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}