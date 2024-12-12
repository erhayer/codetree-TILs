import java.util.Scanner;
import java.util.Arrays;

class Marble {
    int r;
    int c;
    int w;
    int d;

    public Marble(int r, int c, int d, int w) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.w = w;
    }
}

public class Main {
    public static int n;
    public static int m;
    public static int t;
    public static Marble[] marbles;
    public static int num;
    public static boolean[] isExcepted;
    public static int[][] grid;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        marbles = new Marble[m+1];
        num = m;
        isExcepted  = new boolean[m+1];
        grid = new int[n][n];

        for (int i = m; i > 0; i--) {
            marbles[i] = new Marble(sc.nextInt()-1, sc.nextInt()-1, DirMapper(sc.next().charAt(0)), sc.nextInt());
        }

        for (int i = 1; i <= m; i++) {
            isExcepted[i] = false;
        }

        for (int i = 0; i < t; i++) {
            simulate();
        }

        System.out.println(num + " " + getMaxWeight());
    }

    public static void simulate() {
        for (int i = m; i > 0; i--) {
            if (isExcepted[i]) continue;
            int nextR = marbles[i].r + dr[marbles[i].d];
            int nextC = marbles[i].c + dc[marbles[i].d];

            if (!inRange(nextR, nextC)) {
                marbles[i].d = (marbles[i].d + 2) % 4;
            } else {
                marbles[i].r = nextR;
                marbles[i].c = nextC;
            }

            if (grid[marbles[i].r][marbles[i].c] > 0) {
                marbles[grid[marbles[i].r][marbles[i].c]].w += marbles[i].w;
                isExcepted[i] = true;
                num--;
            } else {
                grid[marbles[i].r][marbles[i].c] = i;
            }
        }

        for (int i = m; i > 0; i--) {
            if (isExcepted[i]) continue;
            
            grid[marbles[i].r][marbles[i].c] = 0;
        }
    }

    public static int getMaxWeight() {
        int max = 0;
        
        for (int i = m; i > 0; i--) {
            if (isExcepted[i]) continue;
            
            max = Math.max(marbles[i].w, max);
        }

        return max;
    }

    public static int DirMapper(char dirChar) {
        if (dirChar == 'U') {
            return 0;
        } else if (dirChar == 'R') {
            return 1;
        } else if (dirChar == 'D') {
            return 2;
        } else {
            return 3;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}