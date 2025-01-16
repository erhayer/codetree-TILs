import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

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
    public static int k;

    public static int[][] grid;
    public static boolean[][] visited;

    public static Pair[] startingNodes;
    public static ArrayList<Pair> rocks;
    public static int rockCount = 0;

    public static int max = 0;

    public static Queue<Pair> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        rocks = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if (grid[i][j] == 1) {
                    rocks.add(new Pair(i, j));
                    rockCount++;
                }
            }
        }

        startingNodes = new Pair[k];
        for (int i = 0; i < k; i++) {
            startingNodes[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
        }

        chooseRemovedRock(0, 0);

        //System.out.println(rockCount + " " + m);
        System.out.println(max);
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < k; i++) {
            visited[startingNodes[i].r][startingNodes[i].c] = true;
        }
    }

    public static void chooseRemovedRock(int cnt, int idx) {
        if (cnt == m) {
            max = Math.max(countTiles(), max);
            return;
        }

        if (idx >= rockCount) {
            return;
        }

        grid[rocks.get(idx).r][rocks.get(idx).c] = 0;
        chooseRemovedRock(cnt + 1, idx + 1);
        grid[rocks.get(idx).r][rocks.get(idx).c] = 1;
        chooseRemovedRock(cnt, idx + 1);
    }

    public static int countTiles() {
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            q.add(startingNodes[i]);
            cnt++;
        }
        initializeVisited();

        while (!q.isEmpty()) {
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

        return cnt;
    }

    public static boolean canGo(int r, int c) {
        return inRange(r, c) && grid[r][c] == 0 && !visited[r][c];
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}