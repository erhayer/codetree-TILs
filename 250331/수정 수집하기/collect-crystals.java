import java.util.Scanner;

public class Main {
    private static int n;
    private static int k;

    private static int[][] crystal; // 0 = L 1 = R

    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        crystal = new int[2][n + 1];

        String str = sc.next();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'L') {
                crystal[0][i + 1] = 1;
            } else {
                crystal[1][i + 1] = 1;
            }
        }

        dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (dp[i][j] == -1) continue;
                
                dp[i + 1][j] = Math.max(dp[i][j] + crystal[j % 2][i + 1], dp[i + 1][j]);

                if (j != k) {
                    dp[i + 1][j + 1] = Math.max(dp[i][j] + crystal[(j + 1) % 2][i + 1], dp[i + 1][j + 1]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i <= k; i++) {
            max = Math.max(dp[n][i], max);
        }

        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <=k; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(max);
    }
}