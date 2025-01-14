import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;
    
    public static int currCnt;
    public static int maxCnt = 0;
    public static int blockCnt = 0;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    currCnt = 0;
                    dfs(i, j, grid[i][j]);
                    maxCnt = Math.max(currCnt, maxCnt);

                    if (currCnt >= 4) blockCnt++;
                }
            }
        }

        System.out.println(blockCnt + " " + maxCnt);
    }

    public static void dfs(int r, int c, int num) {
        visited[r][c] = true;
        currCnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (canGo(nr, nc, num)) {
                dfs(nr, nc, num);
            }
        }
    }

    public static boolean canGo(int r, int c, int num) {
        return (r >= 0 && r < n && c >= 0 && c < n) && grid[r][c] == num && !visited[r][c];
    }
}