import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int c;
    public static int[][] room;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        room = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        
        int max = 0;
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 <= n - m; c1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    for (int c2 = 0; c2 <= n - m; c2++) {
                        if (r1 == r2 && Math.abs(c1 - c2) < m) continue;

                        max = Math.max(getMaximumValue(r1, c1, 0) + getMaximumValue(r2, c2, 0), max);
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int getMaximumValue(int r1, int c1, int t) {
        if (t >= m) {
            int squareSum = 0;
            int sum = 0;

            for (int i = 0; i < m; i++) {
                sum += room[r1][c1 + i];
                squareSum += room[r1][c1 + i] * room[r1][c1 + i];                
            }

            if (sum <= c) {
                return squareSum;
            }

            return 0;
        }

        int temp = room[r1][c1 + t];
        room[r1][c1 + t] = 0;
        int tempVal = getMaximumValue(r1, c1, t + 1);
        room[r1][c1 + t] = temp;
        return Math.max(tempVal, getMaximumValue(r1, c1, t + 1));
    }
}