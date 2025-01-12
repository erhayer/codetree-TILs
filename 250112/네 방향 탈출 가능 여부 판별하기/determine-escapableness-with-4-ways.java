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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                visited[i][j] = false;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        int ans = 0;

        while (!q.isEmpty()) {
            Pair currNode = q.poll();

            int r = currNode.r;
            int c = currNode.c;

            //System.out.println(r + " " + c);

            if (r == n - 1 && c == m - 1) {
                ans = 1;
                break;
            }

            if (canGo(r + 1, c)) {
                visited[r + 1][c] = true;
                q.add(new Pair(r + 1, c));
            }

            if (canGo(r, c + 1)) {
                visited[r][c + 1] = true;
                q.add(new Pair(r, c + 1));
            }
            if (canGo(r - 1, c)) {
                visited[r - 1][c] = true;
                q.add(new Pair(r - 1, c));
            }

            if (canGo(r, c - 1)) {
                visited[r][c - 1] = true;
                q.add(new Pair(r, c - 1));
            }
        }

        System.out.println(ans);
    }

    public static boolean canGo(int r, int c) {
        return inRange(r, c) && !visited[r][c] && grid[r][c] == 1;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}