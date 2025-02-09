import java.util.Scanner;

public class Main {
    public static final int MAX_M = 10000;
    
    public static int n;
    public static int m;

    public static int[] coins;
    public static int[] dp = new int[MAX_M + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        for (int i = 0; i <= MAX_M; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= MAX_M; j++) {
                if (j >= coins[i]) {
                    if (dp[j - coins[i]] == -1) {
                        continue;
                    }

                    dp[j] = Math.max(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }

        System.out.println(dp[m]);
    }
}