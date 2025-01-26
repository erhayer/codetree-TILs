import java.util.Scanner;

public class Main {
    public static int n;

    public static int[][] grid;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], grid[0][i]);
            dp[i][0] = Math.max(dp[i - 1][0], grid[i][0]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i][j - 1], dp[i - 1][j]), grid[i][j]);
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}