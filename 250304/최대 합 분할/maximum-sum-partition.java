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

        int offset = m;
        
        int[] dp = new int[2 * m + 1];
        for (int i = -m; i <= m; i++) {
            dp[i + offset] = -1;
        }
        dp[0 + offset] = 0;

        for (int i = 1; i <= n; i++) {
            int num = arr[i];
            int[] nextDp = new int[2 * m + 1];
            for (int j = -m; j <= m; j++) {
                nextDp[j + offset] = dp[j + offset];
            }

            for (int j = -m; j <= m; j++) {
                if (dp[j + offset] != -1) {
                    nextDp[j - num + offset] = Math.max(dp[j + offset], nextDp[j - num + offset]);
                    nextDp[j + num + offset] = Math.max(dp[j + offset] + num, nextDp[j + num + offset]);
                }
            }

            for (int j = -m; j <= m; j++) {
                dp[j + offset] = nextDp[j + offset];
            }
        }

        System.out.println(dp[0 + offset]);
    }
}