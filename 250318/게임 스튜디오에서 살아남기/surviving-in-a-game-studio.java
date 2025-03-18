import java.util.Scanner;

public class Main {
    public static final int MAX_T = 3;
    public static final int MAX_B = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][][] dp = new int[n + 1][MAX_B][MAX_T]; //dp[i][j][k] B가 연속으로 j번 T가 k번 나온 길이가 i인 평가 문자열의 가짓수

        dp[0][0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < MAX_B; j++) {
                for (int k = 0; k < MAX_T; k++) {
                    if (j < MAX_B - 1) { // B를 마지막에 붙이는 경우
                        dp[i + 1][j + 1][k] += dp[i][j][k];
                    }

                    if (k < MAX_T - 1) { // T를 마지막에 붙이는 경우
                        dp[i + 1][0][k + 1] += dp[i][j][k];
                    }

                    //G를 붙이는 경우
                    dp[i + 1][0][k] += dp[i][j][k];
                }
            }
        }

        int sum = 0;

        for (int j = 0; j < MAX_B; j++) {
            for (int k = 0; k < MAX_T; k++) {
                sum += dp[n][j][k];
            }
        }

        System.out.println(sum);
    }
}