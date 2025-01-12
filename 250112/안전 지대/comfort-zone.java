import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;

    public static int[][] grid;
    public static boolean[][] canGo;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        canGo = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxCnt = 0;
        int minK = 100;

        for (int k = 1; k < 100; k++) {
            findSafeArea(k);

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (canGo[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            if (cnt > maxCnt) {
                maxCnt = cnt;
                minK = k;
            }
        }

        System.out.println(minK + " " + maxCnt);
    }

    public static void dfs(int r, int c) {
        canGo[r][c] = false;
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (inRange(nr, nc) && canGo[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static void findSafeArea(int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > k) {
                    canGo[i][j] = true;
                } else {
                    canGo[i][j] = false;
                }
            }
        }
    }
}