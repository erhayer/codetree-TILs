import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;

    public static int[] arr;
    public static boolean[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        dp = new boolean[m + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i <= m; i++) {
            dp[i] = false;
        }
        dp[0] = true;


        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= arr[i]) {
                    if (dp[j - arr[i]] == true) {
                        dp[j] = true;
                    }
                }
            }
        }

        System.out.println(dp[m] ? "Yes" : "No");
    }
}