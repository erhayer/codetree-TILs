import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[][] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        memo[0][n - 1] = grid[0][n - 1];
        for (int i = 1; i < n; i++) {
            memo[0][n - 1 - i] = memo[0][n - i] + grid[0][n - 1 - i];
            memo[i][n - 1] = memo[i - 1][n - 1] + grid[i][n - 1];
        }

        System.out.println(findMinSum(n - 1, 0));
    }

    public static int findMinSum(int r, int c) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }

        memo[r][c] = Math.min(findMinSum(r - 1, c), findMinSum(r, c + 1)) + grid[r][c];

        return memo[r][c];
    }
}