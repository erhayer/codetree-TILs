import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;

    public static int[][] grid;
    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                for (int r = 0; r < i; r++) {
                    for (int c = 0; c < j; c++) {
                        if(dp[r][c] != -1 && grid[r][c] < grid[i][j]) {
                            dp[i][j] = Math.max(dp[r][c] + 1, dp[i][j]);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
                //System.out.print(dp[i][j] + " ");
            }
            //System.out.println();
        }

        System.out.println(max);
    }
}