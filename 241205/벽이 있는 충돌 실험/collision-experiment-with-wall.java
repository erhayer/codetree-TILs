import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] balls = new int[m][3];

            for (int j = 0; j < m; j++) {
                balls[j] = new int[]{sc.nextInt() - 1, sc.nextInt() - 1, dirMapper(sc.next().charAt(0))};
            }

            sb.append(simulate(n, m, balls)).append("\n");
        }

        System.out.println(sb);
    }

    public static int simulate(int n, int m, int[][] balls) {
        int[][] grid = new int[n][n];
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }

        for (int i = 0; i < m; i++) {
            grid[balls[i][0]][balls[i][1]] = balls[i][2];
        }

        //printGrid(grid, n);

        for (int i = 0; i < 2*n; i++) {
            int[][] nextGrid = new int[n][n];
            int[][] nextNumGrid = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int dir = grid[j][k];

                    if (dir >= 0) {
                        int nextR = j + dr[dir];
                        int nextC = k + dc[dir];

                        if (inRange(nextR, nextC, n)) {
                            nextGrid[nextR][nextC] = dir;
                            nextNumGrid[nextR][nextC]++;
                        } else {
                            nextGrid[j][k] = (dir + 2) % 4;
                            nextNumGrid[j][k]++;
                        }
                    }

                    
                }
            }

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (nextNumGrid[r][c] == 1) {
                        grid[r][c] = nextGrid[r][c];
                    } else {
                        grid[r][c] = -1;
                    }
                }
            }

            //printGrid(grid, n);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] >= 0) count++;
            }
        }

        return count;
    }

    public static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static int dirMapper(char dirChar) {
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

    public static void printGrid(int[][] grid, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n;j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}