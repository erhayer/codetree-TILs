import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                int tempSum = 0;

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        tempSum += grid[i+r][j+c];
                    }
                }

                max = Math.max(tempSum, max);
            }
        }

        System.out.println(max);
    }
}