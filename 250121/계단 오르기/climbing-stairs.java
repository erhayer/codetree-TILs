import java.util.Scanner;

public class Main {
    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i <= MAX_N; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;

        for (int i = 0; i <= MAX_N; i++) {
            if (i + 2 <= MAX_N) {
                dp[i + 2] = (dp[i + 2] + dp[i]) % 10007;
            }
            if (i + 3 <= MAX_N) {
                dp[i + 3] = (dp[i + 3] + dp[i]) % 10007;
            }
        }

        System.out.println(dp[sc.nextInt()]);
    }
}