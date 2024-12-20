import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] numGrid;
    public static int[][] dirGrid;

    public static int currMoves = 0;
    public static int maxMoves = 0;

    public static int[] dr = new int[]{0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = new int[]{0, 0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        numGrid = new int[n][n];
        dirGrid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numGrid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dirGrid[i][j] = sc.nextInt();
            }
        }

        int initR = sc.nextInt() - 1;
        int initC = sc.nextInt() - 1;

        findMaxMoves(initR, initC);

        System.out.println(maxMoves);
    }

    public static void findMaxMoves(int r, int c) {
        int num = numGrid[r][c];
        int dir = dirGrid[r][c];

        int nextR = r + dr[dir];
        int nextC = c + dc[dir];

        boolean isStuck = true;

        while (inRange(nextR, nextC)) {
            if (numGrid[nextR][nextC] > num) {
                currMoves++;
                findMaxMoves(nextR, nextC);
                currMoves--;

                isStuck = false;
            }

            nextR += dr[dir];
            nextC += dc[dir];
        }

        if (isStuck) {
            maxMoves = Math.max(currMoves, maxMoves);
            return;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >=0 && r < n && c >= 0 && c < n;
    }
}