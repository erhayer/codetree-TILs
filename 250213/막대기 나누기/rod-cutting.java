import java.util.Scanner;

public class Main {
    public static int n;

    public static int[] prices;
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        prices = new int[n + 1];
        dp = new int[n + 1];

        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            prices[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = prices[i];

            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[n]);
    }
}