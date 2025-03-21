import java.util.Scanner;

public class Main {
    private static int n;

    private static int[] s;
    private static int[] b;

    private static int[][][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = new int[n + 1];
        b = new int[n + 1];
        dp = new int[n + 1][11 + 1][9 + 1];

        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 11; j++) {
                for (int k = 0; k <= 9; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 11; j++) {
                for (int k = 0; k <= 9; k++) {
                    if (dp[i][j][k] == -1) continue;

                    dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k]);

                    if (j < 11) {
                        dp[i + 1][j + 1][k] = Math.max(dp[i + 1][j + 1][k], dp[i][j][k] + s[i + 1]);
                    }
                    if (k < 9) {
                        dp[i + 1][j][k + 1] = Math.max(dp[i + 1][j][k + 1], dp[i][j][k] + b[i + 1]);
                    }
                }
            }
        }

        System.out.println(dp[n][11][9]);
    }
}