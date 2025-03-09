import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        boolean[] dp;

        int sum = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + arr[i]] = true;
                }
            }
        }

        if (sum % 2 == 0 && dp[sum / 2] == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}