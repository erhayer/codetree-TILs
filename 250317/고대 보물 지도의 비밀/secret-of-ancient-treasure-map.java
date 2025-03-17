import java.util.Scanner;

public class Main {
    private static int n;
    private static int k;

    private static int[] arr;
    private static int[][] dp; // dp[i][j]: i번째에 끝나고 음수가 k개 나왔을 때의 최댓값 

    private static final int MIN_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n + 1];
        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = MIN_VALUE;
            }
        }
        

        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0) {
                for (int j = 0; j <= k; j++) {
                    if (dp[i - 1][j] != MIN_VALUE) {
                        dp[i][j] = dp[i - 1][j] + arr[i];
                    }
                }

                dp[i][0] = Math.max(dp[i][0], arr[i]);
            } else {
                for (int j = 1; j <= k; j++) {
                    if (dp[i - 1][j - 1] != MIN_VALUE) {
                        dp[i][j] = dp[i - 1][j - 1] + arr[i];
                    }
                }

                dp[i][1] = Math.max(dp[i][1], arr[i]);
            }
        }

        int max = MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        System.out.println(max);
    }
}