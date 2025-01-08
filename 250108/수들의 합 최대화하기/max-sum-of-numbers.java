import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int max = Integer.MIN_VALUE;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        chooseColumns(0, 0);

        System.out.println(max);
    }

    public static void chooseColumns(int row, int sum) {
        if (row == n) {
            max = Math.max(sum, max);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                chooseColumns(row + 1, sum + grid[row][i]);
                visited[i] = false;
            }
        }
    }
}