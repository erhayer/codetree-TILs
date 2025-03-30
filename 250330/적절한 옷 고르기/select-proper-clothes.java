import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;

    private static int[] clothesScore;
    private static boolean[][] clothesDay;

    private static int[][] dp; //dp[i][j]: i일에 마지막에 j를 입었을 때의 최대 만족도

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        clothesScore = new int[n];
        clothesDay = new boolean[m][n];

        dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int score = sc.nextInt();

            for (int j = s - 1; j < e; j++) {
                clothesDay[j][i] = true;
            }

            clothesScore[i] = score;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (clothesDay[0][i] == true) {
                dp[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (clothesDay[i][j] == false) continue;

                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][k] == -1) continue;

                    dp[i][j] = Math.max(dp[i - 1][k] + Math.abs(clothesScore[j] - clothesScore[k]), dp[i][j]);
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(dp[m - 1][i], max);
        }

        System.out.println(max);
    }
}