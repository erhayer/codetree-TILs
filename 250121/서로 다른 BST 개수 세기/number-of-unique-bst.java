import java.util.Scanner;

public class Main {
    public static final int MAX_N = 19;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[(i - 1) - j];
            }
        }

        System.out.println(dp[sc.nextInt()]);
    }
}