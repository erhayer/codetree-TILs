import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n;
    public static int k;

    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;

    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                step[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;

                if (grid[i][j] == 2) {
                    push(i, j, 0);
                }
            }
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    sb.append(-1);
                } else if (step[i][j] == -1) {
                    sb.append(-2);
                } else {
                    sb.append(step[i][j]);
                }
                sb.append(" ");
            }

            sb.append("\n");
        }


        System.out.println(sb);
    }

    public static void push(int r, int c, int s) {
        q.add(new Pair(r, c));
        visited[r][c] = true;
        step[r][c] = s;
    }

    public static void BFS() {
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
                    push(nr, nc, step[r][c] + 1);
                }
            }
        }
    }

    public static boolean canGo(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c];
    }
}

class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}