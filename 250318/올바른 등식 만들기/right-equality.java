import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;
    
    private static final int MAX_N = 20;
    private static final int OFFSET = MAX_N;
    
    private static int[] arr;
    private static long[][] dp; // dp[i][j]: i번째까지 고려했을 때 합이 j가 될 수 있는 경우의 수
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp = new long[n + 1][MAX_N * 2 + 1];
        dp[0][0 + OFFSET] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = -20; j <= 20; j++) {
                if (dp[i][j + OFFSET] != 0) {
                    if (inRange(j + arr[i + 1])) {
                        dp[i + 1][j + arr[i + 1] + OFFSET] += dp[i][j + OFFSET];
                    }
                    if (inRange(j - arr[i + 1])) {
                        dp[i + 1][j - arr[i + 1] + OFFSET] += dp[i][j + OFFSET];
                    }
                }
            }
        }

        System.out.println(dp[n][m + OFFSET]);
    }

    private static boolean inRange(int num) {
        return num >= -MAX_N && num <= MAX_N;
    }
}