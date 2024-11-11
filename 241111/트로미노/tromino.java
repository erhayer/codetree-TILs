import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0;  j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int max = 0;

        //horizontal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 2; j++) {
                max = Math.max(calHorizontalSum(matrix, i, j), max);
            }
        }

        //Vertical
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(calVerticalSum(matrix, i, j), max);
            }
        }

        //stair
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                max = Math.max(calStairSum(matrix, i, j), max);
            }
        }

        System.out.println(max);
    }

    public static int calHorizontalSum(int[][] matrix, int r, int c) {
        int sum = 0;
        
        for (int i = c; i < c+3; i++) {
            sum += matrix[r][i];
        }

        return sum;
    }

    public static int calVerticalSum(int[][] matrix, int r, int c) {
        int sum = 0;
        
        for (int i = r; i < r+3; i++) {
            sum += matrix[i][c];
        }

        return sum;
    }

    public static int calStairSum(int[][] m, int r, int c) {
        int squareSum = m[r][c] + m[r+1][c] + m[r][c+1] + m[r+1][c+1];

        return squareSum - Math.min(Math.min(Math.min(m[r][c], m[r+1][c]), m[r][c+1]), m[r+1][c+1]);
    }
}