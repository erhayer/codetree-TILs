import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int t;
    public static int[][] numGrid;
    public static int[][] ballGrid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        numGrid = new int[n][n];
        ballGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numGrid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;

            ballGrid[r][c] = 1;
        }

        for (int i = 0; i < t; i++) {
            simulate();
        }

        System.out.println(countBalls());
    }

    public static void simulate() {
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        int[][] nextGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ballGrid[i][j] == 1) {
                    int maxdir = 3;
                    int max = 0;

                    for (int dir = 3; dir >= 0; dir--) {
                        int tr = i + dr[dir];
                        int tc = j + dc[dir];

                        if (inRange(tr, tc) && numGrid[tr][tc] >= max) {
                            maxdir = dir;
                            max = numGrid[tr][tc];
                        }
                    }

                    nextGrid[i + dr[maxdir]][j + dc[maxdir]] += 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextGrid[i][j] == 1) {
                    ballGrid[i][j] = 1;
                } else {
                    ballGrid[i][j] = 0;
                }
            }
        }
    }

    public static int countBalls() {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += ballGrid[i][j];
            }
        }

        return count;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}