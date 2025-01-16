import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Pair { 
    int r;
    int c;

    public Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main {
    public static int n;
    public static int m;

    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;

    public static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];
        step = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
                step[i][j] = -1;
            }
        }

        q.add(new Pair(0, 0));
        step[0][0] = 0;

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    visited[nr][nc] = true;
                    step[nr][nc] = step[r][c] + 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        System.out.println(step[n - 1][m - 1]);
    }

    public static boolean canGo(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c];
    }
}