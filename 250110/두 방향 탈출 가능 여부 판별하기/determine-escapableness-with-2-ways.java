import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static boolean[][] isVisited;

    public static boolean ans = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
           
        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                isVisited[i][j] = false;
            }
        }
        
        isPossible(0, 0);

        System.out.println(ans ? 1 : 0);
    }

    public static void isPossible(int r, int c) {
        if (r == n - 1 && c == m - 1) {
            ans = true;
        }

        if (canGoD(r, c)) {
            isVisited[r + 1][c] = true;
            isPossible(r + 1, c);
        }

        if (canGoC(r, c)) {
            isVisited[r][c + 1] = true;
            isPossible(r, c + 1);
        }
    }

    public static boolean canGoD(int r, int c) {
        if (inRange(r + 1, c) && grid[r + 1][c] != 0 && isVisited[r + 1][c] == false) {
            return true;
        }

        return false;
    }

    public static boolean canGoC(int r, int c) {
        if (inRange(r, c + 1) && grid[r][c + 1] != 0 && isVisited[r][c + 1] == false) {
            return true;
        }

        return false;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}