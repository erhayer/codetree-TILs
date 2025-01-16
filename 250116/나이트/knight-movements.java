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
    
    public static boolean[][] visited;
    public static int[][] step;

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dr = new int[]{-2, -2, -1, 1, 2, 2, 1, -1};
    public static int[] dc = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;

        visited = new boolean[n][n];
        step = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                step[i][j] = -1;
            }
        }

        q.add(new Pair(r1, c1));
        visited[r1][c1] = true;
        step[r1][c1] = 0;

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    visited[nr][nc] = true;
                    step[nr][nc] = step[r][c] + 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        System.out.println(step[r2][c2]);
    }

    public static boolean canGo(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && !visited[r][c];
    }
}