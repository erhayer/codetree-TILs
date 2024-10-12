import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int temp_sum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-2; j++) {
                temp_sum = mat[i][j] + mat[i][j+1] + mat[i][j+2];
                max = Math.max(temp_sum, max);
            }
        }

        System.out.println(max);
    }
}