import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;

    public static int[] weights;
    public static int[] values;

    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        weights = new int[n + 1];
        values = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (weights[i] <= j && dp[j - weights[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
                }
            }
        } 

        int max = 0;
        for (int i = 1; i <= m; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}