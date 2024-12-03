import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int grid[][];
    public static int numPos[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numPos = new int[n*n + 1][2];
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                grid[i][j] = num;
                numPos[num][0] = i;
                numPos[num][1] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            simulate();
        }

        printGrid();
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void printGrid() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void simulate() {
        int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 1; i <= n*n; i++) {
            int r = numPos[i][0];
            int c = numPos[i][1];

            int maxR = r;
            int maxC = c;
            int maxNum = 0;

            for (int d = 0; d < 8; d++) {
                int tr = r + dr[d];
                int tc = c + dc[d];

                if (inRange(tr, tc) && grid[tr][tc] > maxNum) {
                    maxR = tr;
                    maxC = tc;
                    maxNum = grid[tr][tc];
                }
            }

            int[] tempPos = numPos[grid[r][c]];
            numPos[grid[r][c]] = numPos[grid[maxR][maxC]];
            numPos[grid[maxR][maxC]] = tempPos;

            int temp = grid[r][c];
            grid[r][c] = grid[maxR][maxC];
            grid[maxR][maxC] = temp;
        }
    }
}