import java.util.Scanner;

public class Main {
    public static int n;
    
    public static int[][] grid;
    public static int[][] memo;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];
        memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                memo[i][j] = -1;
            }
        }

        int max = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(findMaxSequence(i, j), max);
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(memo[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(max);
    }

    public static int findMaxSequence(int r, int c) {
        if (memo[r][c] != -1) {
            return memo[r][c];
        }

        int len = 1;

        for (int i = 0; i < 4; i++) {
            if (inRange(r + dr[i], c + dc[i]) && grid[r][c] > grid[r + dr[i]][c + dc[i]]) {
                len = Math.max(len, findMaxSequence(r + dr[i], c + dc[i]) + 1);
            }
        }
        memo[r][c] = len;

        return memo[r][c];
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}