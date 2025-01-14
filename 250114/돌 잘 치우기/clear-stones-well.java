import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair {
    int r;
    int c;

    public Pair (int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    public static int n;
    public static int k;
    public static int m;

    public static int[][] grid;
    public static boolean[][] visited;

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

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
                q.add(new Pair(r, c));
                visited[r][c] = true;
                cnt++;
                bfs();
            }
        }

        System.out.println(12);
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    cnt++;
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static boolean canGo(int r, int c) {
        return inRange(r, c) && grid[r][c] == 0 && !visited[r][c];
    }
}