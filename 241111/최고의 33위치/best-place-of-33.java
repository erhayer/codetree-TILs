import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0;  j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                max = Math.max(calSquareSum(matrix, i, j), max);
            }
        }

        System.out.println(max);
    }

    public static int calSquareSum(int[][] matrix, int r, int c) {
        int sum = 0;
        
        for (int i = r; i < r+3; i++) {
            for (int j = c; j < c+3; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }
}