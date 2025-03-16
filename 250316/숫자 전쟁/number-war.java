import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] cards1;
    public static int[] cards2;

    public static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        cards1 = new int[n];
        cards2 = new int[n];

        dp = new int[n + 1][n + 1]; //dp[i][j]: 상대방 카드 j장 남우의 카드 i장의 소모했을 때의 남우의 최대 점수

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            cards1[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cards2[i] = sc.nextInt();
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == - 1) continue;

                dp[i + 1][j + 1] = dp[i][j];

                if (cards2[i] < cards1[j]) {
                    dp[i + 1][j] = Math.max(dp[i][j] + cards2[i], dp[i + 1][j]);
                } else if (cards2[i] > cards1[j]) {
                    dp[i][j + 1] = Math.max(dp[i][j], dp[i][j + 1]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == n || j == n) {
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         sb.append(dp[i][j]).append(" ");
        //     }
        //     sb.append("\n");
        // }

        // System.out.println(sb);
        System.out.println(max);
    }
}