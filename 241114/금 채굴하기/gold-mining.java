import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int max = 0;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(mineGold(mat, i, j, k, n, m), max);
                }
            }
        }

        //mineGold(mat, 3, 3, 2, n, m);

        System.out.println(max);
    }

    public static int mineGold(int[][] mat, int r, int c, int k, int n, int m) {
        int goldSum = 0;
        int goldCount = 0;
        
        for (int i = r - k; i <= r + k; i++) {
            for (int j = c - k; j <= c + k; j++) {
                if (inRange(i, j, n) && Math.abs(r-i) + Math.abs(c-j) <= k && mat[i][j] == 1) {
                    goldSum += m;
                    goldCount++;

                    //System.out.println(i + " " + j);
                }
            }
        }

        //System.out.println(r + " " + c + " " + k + " -- " + (goldSum - (k*k + (k+1)*(k+1))) + " " + goldCount);

        if (goldSum - (k*k + (k+1)*(k+1)) >= 0) {
            return goldCount;
        } else {
            return 0;
        }
    }

    public static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}