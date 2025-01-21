import java.util.Scanner;

public class Main {
    public static final int MAX_N = 45;
    
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 2; i <= MAX_N; i++) {
            dp[i] = -1;
        }

        for (int i = 2; i <= MAX_N; i++) {
            fibonacci(i);
        }

        System.out.println(fibonacci(sc.nextInt()));
    }

    public static int fibonacci(int n) {
        if (dp[n] == -1) {
            dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }

        return dp[n];
    }
}