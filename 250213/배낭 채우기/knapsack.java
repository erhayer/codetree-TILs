import java.util.Scanner;

class Jewel {
    int w;
    int v;

    public Jewel (int w, int v) {
        this.w = w;
        this.v = v;
    }
}
public class Main {
    public static int n;
    public static int m;

    public static Jewel[] jewels;
    public static int[][] dp; // dp[i][j] = i 번째 보석까지 고려했을 때 무게가 j 인 경우의 최대 value

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        jewels = new Jewel[n + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            jewels[i] = new Jewel(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                }
                if (dp[i - 1][j] != -1 && j + jewels[i].w <= m) {
                    dp[i][j + jewels[i].w] = Math.max(dp[i][j + jewels[i].w], dp[i - 1][j] + jewels[i].v);
                }
            }
        }

        int max = 0;
        for (int j = 1; j <= m; j++) {
            max = Math.max(dp[n][j], max);
        }

        System.out.println(max);
    }
}