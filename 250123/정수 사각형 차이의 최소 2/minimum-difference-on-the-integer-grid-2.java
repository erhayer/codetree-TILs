import java.util.Scanner;

public class Main {
    public static int n;

    public static int[][] grid;
    public static int[][] maxDp;
    public static int[][] minDp;
    public static int[][] dp;    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];
        maxDp = new int[n][n];
        minDp = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        maxDp[0][0] = grid[0][0];
        minDp[0][0] = grid[0][0];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            maxDp[0][i] = Math.max(maxDp[0][i - 1], grid[0][i]);
            maxDp[i][0] = Math.max(maxDp[i - 1][0], grid[i][0]);

            minDp[0][i] = Math.min(minDp[0][i - 1], grid[0][i]);
            minDp[i][0] = Math.min(minDp[i - 1][0], grid[i][0]);

            dp[0][i] = maxDp[0][i] - minDp[0][i];
            dp[i][0] = maxDp[i][0] - minDp[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (cal(i - 1, j, i, j) < cal(i, j - 1, i, j)) {
                    maxDp[i][j] = Math.max(maxDp[i - 1][j], grid[i][j]);
                    minDp[i][j] = Math.min(minDp[i - 1][j], grid[i][j]);
                    dp[i][j] = cal(i - 1, j, i, j);
                } else {
                    maxDp[i][j] = Math.max(maxDp[i][j - 1], grid[i][j]);
                    minDp[i][j] = Math.min(minDp[i][j - 1], grid[i][j]);
                    dp[i][j] = cal(i, j - 1, i, j);
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
    }

    public static int cal(int r1, int c1, int r2, int c2) {
        return Math.max(maxDp[r1][c1], grid[r2][c2]) - Math.min(minDp[r1][c1], grid[r2][c2]);
    }
}