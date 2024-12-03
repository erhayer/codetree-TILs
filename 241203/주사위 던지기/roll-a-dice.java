import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] grid;
    public static int r;
    public static int c;
    public static int bottom = 6;
    public static int front = 2;
    public static int right = 3;
    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        grid = new int[n][n];

        r = sc.nextInt()-1;
        c = sc.nextInt()-1;

        grid[r][c] = bottom;

        for (int i = 0; i < m; i++) {
            char dirChar = sc.next().charAt(0);
            roll(dirMapper(dirChar));
        }

        System.out.println(getGridSum());
    }

    public static void roll(int dir) {
        int nextR = r + dr[dir];
        int nextC = c + dc[dir];

        if (!inRange(nextR, nextC)) return;

        r = nextR;
        c = nextC;

        if (dir == 0) {
            int nextFront = bottom;
            bottom = 7 - front;
            front = nextFront;            
        } else if (dir == 1) {
            int nextRight = 7 - bottom;
            bottom = right;
            right = nextRight;
        } else if (dir == 2) {
            int nextFront = 7 - bottom;
            bottom = front;
            front = nextFront;
        } else {
            int nextRight = bottom;
            bottom = 7 - right;
            right = nextRight;
        }

        grid[r][c] = bottom;
    }

    public static int dirMapper(char dir) {
        if (dir == 'L') {
            return 3;
        } else if (dir == 'R') {
            return 1;
        } else if (dir == 'U') {
            return 0;
        }
        return 2;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static int getGridSum() {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }
}