import java.util.Scanner;

public class Main {
    private static final int ROOM_NUM = 3;

    private static int n;
    private static int[][] rooms;
    private static int[][][] dp; // dp[i][j][k] i번째에서 시작하지 않고 j층 k번째 방까지 왔을 떄의 최대
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        rooms = new int[n][ROOM_NUM];
        dp = new int[ROOM_NUM][n][ROOM_NUM];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < ROOM_NUM; j++) {
                rooms[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < ROOM_NUM; i++) {
            for (int j = 0; j < ROOM_NUM; j++) {
                if (i == j) continue;

                dp[i][0][j] = rooms[0][j];
            }
        }

        for (int i = 0; i < ROOM_NUM; i++) {
            
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < ROOM_NUM; k++) {
                    for (int l = 0; l < ROOM_NUM; l++) {
                        if (k == l) continue;

                        dp[i][j][k] = Math.max(dp[i][j - 1][l], dp[i][j][k]);
                    }

                    dp[i][j][k] += rooms[j][k];
                }
            }
        }

        int max = 0;

        for (int i = 0; i < ROOM_NUM; i++) {
            max = Math.max(dp[i][n - 1][i], max);
        }

        System.out.println(max);
    }
}