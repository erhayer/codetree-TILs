import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MOD = 1000000007;
    public static long[] dp = new long[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for (int i = 3; i <= MAX_N; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD;

            for (int j = 3; j <= i; j++) {
                dp[i] = (dp[i] + dp[i - j] * 2) % MOD;
            }
        }
        
        System.out.println(dp[sc.nextInt()]);
    }
}