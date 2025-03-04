import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        
        int m = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            m += arr[i];
        }
        
        boolean[][][] dp = new boolean[n + 1][m + 1][m + 1];
        dp[0][0][0] = true;

        for (int i = 1; i <= n; i++) {
            int num = arr[i];

            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    if (dp[i - 1][j][k]) {
                        dp[i][j][k] = true;
                        dp[i][j + num][k] = true;
                        dp[i][j][num + k] = true;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= m; i++) {
            if (dp[n][i][i]) {
                max = i;
            }
        }

        System.out.println(max);
    }
}