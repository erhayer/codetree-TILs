import java.util.Scanner;

public class Main {
    private static int n;
    private static int m;

    private static int[] arr;

    private static int[][][] dp; // dp[i][j][k]: 끝자리가 k로 끝나고 길이가 i 달라진 횟수가 j 번인 수열의 최대 유사도
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 1];
        dp = new int[n + 1][m + 1][5];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k <= m; k++) {
                    dp[j][k][i] = -1;
                }
            }
        }

        //initial condition
        for (int i = 1; i <= 4; i++) {
            dp[1][0][i] = i == arr[1] ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 1; k <= 4; k++) {
                    if (dp[i][j][k] == -1) continue;

                    dp[i + 1][j][k] = Math.max(dp[i][j][k] + (arr[i + 1] == k ? 1 : 0), dp[i + 1][j][k]);

                    if (j < m) {
                        for (int l = 1; l <= 4; l++) {
                            if (k == l) continue;
                            
                            dp[i + 1][j + 1][l] = Math.max(dp[i][j][k] + (arr[i + 1] == l ? 1 : 0), dp[i + 1][j + 1][l]);
                        }
                    }
                }
            }
        }

        int max = 0;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                max = Math.max(dp[n][i][j], max);
            }
        }

        System.out.println(max);
    }
}