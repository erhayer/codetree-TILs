import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[10000 + 1];

        for (int i = 1; i <= 10000; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            dp[coins[i]] = 1;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] < i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}