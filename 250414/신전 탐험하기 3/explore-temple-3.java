import java.util.Scanner;

public class Main {
    
    private static int n;
    private static int m;

    private static int[][] rooms;
    private static int[][] dp; //dp[i][j] i 층 j 번째 방에서 끝났을 때의 누적 보물의 최대    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        rooms = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rooms[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = rooms[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j == k) continue;

                    dp[i][j] = Math.max(rooms[i][j] + dp[i - 1][k], dp[i][j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(dp[n - 1][i], max);
        }

        System.out.println(max);
    }
}