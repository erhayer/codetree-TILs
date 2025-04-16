import java.util.Scanner;

public class Main {
    
    private static String a;
    private static String b;

    private static int lenA;
    private static int lenB;

    private static char[] arrA;
    private static char[] arrB;

    private static int[][] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        lenA = a.length();
        lenB = b.length();

        arrA = a.toCharArray();
        arrB = b.toCharArray();

        dp = new int[lenA][lenB];

        dp[0][0] = arrA[0] == arrB[0] ? 1 : 0;

        int initVal = dp[0][0];
        for (int i = 1; i < lenA; i++) {
            if (arrA[i] == arrB[0]) initVal = 1;

            dp[i][0] = initVal;
        }

        initVal = dp[0][0];
        for (int i = 1; i < lenB; i++) {
            if (arrA[0] == arrB[i]) initVal = 1;

            dp[0][i] = initVal;
        }

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                if (arrA[i] == arrB[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        // StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < lenA; i++) {
        //     for (int j = 0; j < lenB; j++) {
        //         sb.append(dp[i][j]).append(" ");
        //     }
        //     sb.append("\n");
        // }
        // System.out.println(sb);

        System.out.println(dp[lenA - 1][lenB - 1]);
    }
}