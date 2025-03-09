import java.util.Scanner;
public class Main {
    private static final int MAX_MOVES = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coins[i] = sc.nextInt();
        }
        // Please write your code here.

        //dp[i][j] : i번째 층에서 1계단을 j번 했을 때 얻을 수 있는 동전의 최대 개수
        int[][] dp = new int[n + 1][MAX_MOVES + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= MAX_MOVES; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= MAX_MOVES; j++) {
                if (dp[i][j] != Integer.MIN_VALUE) {
                    if (i < n - 1) {
                        dp[i + 2][j] = Math.max(dp[i + 2][j], dp[i][j] + coins[i + 2]);
                    }
                    if (j < MAX_MOVES) {
                        dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + coins[i + 1]);
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i <= MAX_MOVES; i++) {
            max = Math.max(dp[n][i], max);
        }

        System.out.println(max);
    }
}