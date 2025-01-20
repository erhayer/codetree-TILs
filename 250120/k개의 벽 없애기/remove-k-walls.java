import java.util.*;

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
    public static int k;

    public static int r1;
    public static int c1;
    public static int r2;
    public static int c2;

    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;

    public static ArrayList<Pair> walls = new ArrayList<>();

    public static Queue<Pair> q = new LinkedList<>();

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        step = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if (grid[i][j] == 1) {
                    walls.add(new Pair(i, j));
                }
            }
        }

        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        choose(0, 0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void initializeStep() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                step[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void choose(int cnt, int idx) {
        if (cnt == k) {
            min = Math.min(getTime(), min);
            return;
        }

        if (idx >= walls.size()) {
            return;
        }

        Pair wall = walls.get(idx);

        grid[wall.r][wall.c] = 0;
        choose(cnt + 1, idx + 1);
        grid[wall.r][wall.c] = 1;
        choose(cnt, idx + 1);
    }

    public static int getTime() {
        initializeVisited();
        initializeStep();
        
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        visited[r1][c1] = true;
        step[r1][c1] = 0;
        q.add(new Pair(r1, c1));

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    step[nr][nc] = step[r][c] + 1;
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return step[r2][c2];
    }

    public static boolean canGo(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 0 && !visited[r][c];
    }
}