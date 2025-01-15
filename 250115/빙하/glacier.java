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
    public static int m;

    public static int[][] grid;
    public static boolean[][] visited;

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static int lastMeltedGlacier;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int t = 0;

        while (!isOnlyWater()) {
            t++;
            melt();
        }

        System.out.println(t + " " + lastMeltedGlacier);
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void melt() {
        initializeVisited();
        lastMeltedGlacier = 0;

        q.add(new Pair(0, 0));
        visited[0][0] = true;

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                } else {
                    if(inRange(nr, nc) && grid[nr][nc] == 1) {
                        grid[nr][nc] = -1;
                        lastMeltedGlacier++;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 0;
                }
            }
        }
    }

    public static boolean canGo(int r, int c) {
        return inRange(r, c) && grid[r][c] == 0 && !visited[r][c];
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static boolean isOnlyWater() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return false;
            }
        }

        return true;
    }
}