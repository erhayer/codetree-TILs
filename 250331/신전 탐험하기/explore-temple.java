import java.util.Scanner;

public class Main {
    private static final int ROOM_NUM = 3;
    
    private static int n;
    private static int[][] rooms;
    private static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        rooms = new int[n][ROOM_NUM];
        dp = new int[n][ROOM_NUM]; // dp[i][j]: i층 j번 방에서 끝났을 때의 보물의 최대 개수 *0층부터 시작

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ROOM_NUM; j++) {
                rooms[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < ROOM_NUM; i++) {
            dp[0][i] = rooms[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < ROOM_NUM; j++) {
                for (int k = 0; k < ROOM_NUM; k++) {
                    if (j == k) continue;

                    dp[i][j] = Math.max(dp[i - 1][k], dp[i][j]);
                }

                dp[i][j] += rooms[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < ROOM_NUM; i++) {
            max = Math.max(dp[n - 1][i], max);
        }

        System.out.println(max);
    }
}