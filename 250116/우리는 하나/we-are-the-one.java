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
    public static int k;
    public static int u;
    public static int d;

    public static int[][] grid;
    public static boolean[][] visited;
    public static boolean[][] choosed;

    public static Pair[] choosedCities;
    public static Queue<Pair> q = new LinkedList<>();

    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        choosed = new boolean[n][n];
        choosedCities = new Pair[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                choosed[i][j] = false;
            }
        }

        chooseCities(0);

        System.out.println(max);
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void chooseCities(int cnt) {
        if (cnt == k) {
            max = Math.max(countCities(), max);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!choosed[i][j]) {
                    choosed[i][j] = true;
                    choosedCities[cnt] = new Pair(i, j);
                    chooseCities(cnt + 1);
                    choosed[i][j] = false;
                }
            }
        }
    }

    public static int countCities() {
        int cnt = 0;
        initializeVisited();
        
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        for (int i = 0; i < k; i++) {
            visited[choosedCities[i].r][choosedCities[i].c] = true;
            q.add(choosedCities[i]);
            cnt++;
        }

        while (!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(r, c, nr, nc)) {
                    cnt++;
                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        return cnt;
    }

    public static boolean canGo(int fr, int fc, int tr, int tc) {
        return inRange(tr, tc) && (Math.abs(grid[fr][fc] - grid[tr][tc])) >= u && (Math.abs(grid[fr][fc] - grid[tr][tc])) <= d && !visited[tr][tc];
    }
    
    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}