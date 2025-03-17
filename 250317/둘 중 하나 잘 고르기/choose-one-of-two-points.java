import java.util.Scanner;

public class Main {
    private static int n;

    private static int[] red;
    private static int[] blue;
    private static int[][][] dp;

    private static final int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        red = new int[2 * n + 1];
        blue = new int[2 * n + 1];
        dp = new int[2 * n + 1][n + 1][n + 1]; // i번쨰 시행까지 했을 때 빨간색 카드가 j장, 파란카드가 k장일 때의 총합의 최대

        for (int i = 1; i <= 2 * n; i++) {
            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        //dp init
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if (dp[i][j][k] != -1) {
                        if (j != n) {
                            dp[i + 1][j + 1][k] = Math.max(dp[i][j][k] + red[i + 1], dp[i + 1][j + 1][k]);
                        }
                        if (k != n) {
                            dp[i + 1][j][k + 1] = Math.max(dp[i][j][k] + blue[i + 1], dp[i + 1][j][k + 1]);
                        }
                    }
                }
            }
        }

        System.out.println(dp[2 * n][n][n]);
    }
}