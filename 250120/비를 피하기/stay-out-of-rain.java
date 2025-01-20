import java.util.Scanner;
import java.util.ArrayList;
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
    public static int h;
    public static int m;

    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] ans;

    public static ArrayList<Pair> humans = new ArrayList<>();
    public static ArrayList<Pair> shelters = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 2) {
                    humans.add(new Pair(i , j));
                } else if (grid[i][j] == 3) {
                    shelters.add(new Pair(i, j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < shelters.size(); i++) {
            bfs(shelters.get(i).r, shelters.get(i).c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    sb.append(ans[i][j] == Integer.MAX_VALUE ? -1 : ans[i][j]);
                } else {
                    sb.append(0);
                }

                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    

    public static void bfs(int ir, int ic) {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        ans[ir][ic] = 0;
        q.add(new Pair(ir, ic));

        while (!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(r, c, nr, nc)) {
                    ans[nr][nc] = ans[r][c] + 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }

    }

    public static boolean canGo(int r1, int c1, int r2, int c2) {
        return inRange(r2, c2) && grid[r2][c2] != 1 && ans[r1][c1] + 1 < ans[r2][c2];
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}