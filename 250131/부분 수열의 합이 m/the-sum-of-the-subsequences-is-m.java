import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        
        int[] dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = m; j >= 1; j--) {
                if (j - arr[i] >= 0 && dp[j - arr[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - arr[i]] + 1, dp[j]);
                }
            }
        }

        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }
}