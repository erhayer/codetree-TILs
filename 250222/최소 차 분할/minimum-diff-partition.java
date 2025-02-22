import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static int n;

    public static int[] nums;
    public static boolean[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n + 1];
        dp = new boolean[n + 1][MAX_NUM];

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                if ((j + nums[i] < MAX_NUM && dp[i - 1][j + nums[i]]) || dp[i - 1][Math.abs(j - nums[i])]) {
                    dp[i][j] = true;
                }
            }
        }

        int min = MAX_NUM;
        for (int i = 0; i < MAX_NUM; i++) {
            if(dp[n][i]) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }
}