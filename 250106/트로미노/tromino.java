import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 2; j++) {
                int temp = 0;        
                
                for (int k = 0; k < 3; k++) {
                    temp += grid[i][j + k];
                }

                max = Math.max(temp, max);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = 0;        
                
                for (int k = 0; k < 3; k++) {
                    temp += grid[i + k][j];
                }

                max = Math.max(temp, max);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                max = Math.max(tromino(i, j), max);
            }
        }

        System.out.println(max);
    }

    public static int tromino(int r, int c) {
        int max = 0;

        int total = grid[r][c] + grid[r+1][c] + grid[r][c+1] + grid[r+1][c+1];

        max = Math.max(total - grid[r][c], max);
        max = Math.max(total - grid[r+1][c], max);
        max = Math.max(total - grid[r][c+1], max);
        max = Math.max(total - grid[r+1][c+1], max);

        return max;
    }
}