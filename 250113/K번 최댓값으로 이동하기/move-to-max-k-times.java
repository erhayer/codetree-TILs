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

    public static int[][] grid;
    public static boolean[][] visited;

    public static int initNum;
    public static int initR;
    public static int initC;

    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        initR = sc.nextInt() - 1;
        initC = sc.nextInt() - 1;
        initNum = grid[initR][initC];

        for (int i = 0; i < k; i++) {
            initializeVisited();
            
            bfs();
        }

        System.out.println((initR + 1) + " " + (initC + 1));
    }

    public static void initializeVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static void bfs() {
        q.add(new Pair(initR, initC));
        visited[initR][initC] = true;

        int nextInitR = n;
        int nextInitC = n;
        int nextNum = 0;
        
        while (!q.isEmpty()) {
            Pair node = q.poll();

            int r = node.r;
            int c = node.c;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (canGo(nr, nc)) {
                    if (grid[nr][nc] > nextNum) {
                        nextInitR = nr;
                        nextInitC = nc;
                        nextNum = grid[nr][nc];
                    } else if (grid[nr][nc] == nextNum) {
                        if (nr < nextInitR) {
                            nextInitR = nr;
                            nextInitC = nc;
                            nextNum = grid[nr][nc];
                        } else if (nr == nextInitR) {
                            if (nc < nextInitC) {
                                nextInitR = nr;
                                nextInitC = nc;
                                nextNum = grid[nr][nc];
                            }
                        }
                    }

                    visited[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
        }

        initR = nextInitR == n ? initR : nextInitR;
        initC = nextInitC == n ? initC : nextInitC;
        initNum = grid[initR][initC];
    }

    public static boolean canGo(int r, int c) {
        return (r >= 0 && r < n && c >= 0 && c < n) && grid[r][c] < initNum && !visited[r][c];
    }
}