import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = 100;
        int[] exp = new int[n + 1];
        int[] time = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            exp[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        // Please write your code here.

        int[][] dp = new int[n + 1][1 + t * t]; //dp[i][j] i번째 까지 고려했을 때 j초에 얻을 수 있는 경험치의 최댓값
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= t * t; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= t * t; j++) {
                if (dp[i - 1][j] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                    dp[i][j + time[i]] = Math.max(dp[i][j + time[i]], dp[i - 1][j] + exp[i]);
                }
            }
        }

        int minTime = -1;
        for (int i = 1; i <= t * t; i++) {
            if (dp[n][i] >= m) {
                minTime = i;
                break;
            }
        }

        System.out.println(minTime);
    }
}