import java.util.Scanner;

public class Main {
    public static int n;
    
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i >= 1) {
                dp[i] = (dp[i] + dp[i - 1]) % 10007;
            }
            if (i >= 2) {
                dp[i] = (dp[i] + dp[i - 2]) % 10007;
            }
            if (i >= 5) {
                dp[i] = (dp[i] + dp[i - 5]) % 10007;
            }
        }

        System.out.println(dp[n]);
    }
}