import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(simulate(-1, i, 2), max);
            max = Math.max(simulate(i, n, 3), max);
            max = Math.max(simulate(n, i, 0), max);
            max = Math.max(simulate(i, -1, 1), max);
        }

        System.out.println(max);
    }

    public static int simulate(int r, int c, int dir) {
        int time = 0;
        
        while(true) {
            time++;

            r = r + dr[dir];
            c = c + dc[dir];

            if (!inRange(r, c)) {
                break;
            }

            // 0->1  1->0  2->3 3->2
            if (grid[r][c] == 1) {
                dir = dir < 2 ? 1 - dir : 5 - dir;
            } 
            //0->3 1->2 2->1 3->0
            else if (grid[r][c] == 2) {
                dir = 3 - dir;
            }
        }

        return time;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}