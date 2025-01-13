import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {
    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static Queue<Pair> q = new LinkedList<>();

    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            if (!visited[r][c]) {
                bfs(r, c);
            }
        }

        System.out.println(cnt);
    }

    public static void bfs(int r, int c) {
        visited[r][c] = true;
        q.add(new Pair(r, c));
        cnt++;

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int row = node.r;
            int col = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (canGo(nr, nc)) {
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                    cnt++;

                    //System.out.println(nr + " " + nc);
                }
            }
        }
    }

    public static boolean canGo(int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < n) && grid[r][c] == 0 && !visited[r][c];
    }


}