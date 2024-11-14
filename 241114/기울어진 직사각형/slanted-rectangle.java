import java.util.Scanner;

public class Main {
    public static int[][] mat;
    public static int n;
    public static int[] dr = new int[]{-1, -1, 1, 1};
    public static int[] dc = new int[]{1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(maxRectangularSum(i, j), max);
            }
        }

        System.out.println(max);
    }
    
    // O(n^3)
    public static int maxRectangularSum(int r, int c) {
        int max = 0;
        
        for (int right = 1; right < n; right++) {
            for (int left = 1; left < n; left++) {
                if (c - left < 0 || c + right >= n || r - left - right < 0) {
                    break;
                }

                int recSum = 0;

                for (int i = 0; i < right; i++) {
                    r += dr[0];
                    c += dc[0];

                    recSum += mat[r][c];
                }
                for (int i = 0; i < left; i++) {
                    r += dr[1];
                    c += dc[1];

                    recSum += mat[r][c];
                }
                for (int i = 0; i < right; i++) {
                    r += dr[2];
                    c += dc[2];

                    recSum += mat[r][c];
                }
                for (int i = 0; i < left; i++) {
                    r += dr[3];
                    c += dc[3];

                    recSum += mat[r][c];
                }

                max = Math.max(recSum, max);
            }
        }

        return max;
    }
}