import java.util.Scanner;

public class Main {

    private static int n;
    private static final int MAX_NUM = 10;

    private static int[] init;
    private static int[] goal;

    private static int[][] dp; //dp[i][j]: i 번째까지 맞추어져 있고 offset이 j 이 때의 최소 회전 수
                               //offset: + j 되어 있다는 뜻
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        init = new int[n + 1];
        goal = new int[n + 1];

        dp = new int[n + 1][MAX_NUM];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        String str = sc.next();
        for (int i = 1; i <= n; i++) {
            init[i] = str.charAt(i - 1) - '0';
            //System.out.print(init[i]);
        }
        //System.out.println();

        str = sc.next();
        for (int i = 1; i <= n; i++) {
            goal[i] = str.charAt(i - 1) - '0';
            //System.out.print(goal[i]);
        }
        //System.out.println();

        int firstDiff = calDiff(goal[1], init[1]);
        dp[1][0] = (MAX_NUM - firstDiff) % 10;
        dp[1][firstDiff] = firstDiff;

        //System.out.println(dp[1][0] + " " + dp[1][firstDiff]);

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < MAX_NUM; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) continue;

                int diff = calDiff(goal[i + 1], (init[i + 1] + j) % 10);
                
                dp[i + 1][j] = Math.min((MAX_NUM - diff) % 10 + dp[i][j], dp[i + 1][j]);
                dp[i + 1][(j + diff) % 10] = Math.min(diff + dp[i][j], dp[i + 1][(j + diff) % 10]);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < MAX_NUM; i++) {
            min = Math.min(dp[n][i], min);
        }

        System.out.println(min);
    }

    private static int calDiff(int goal, int init) {
        return (goal - init + MAX_NUM) % MAX_NUM;
    }
}