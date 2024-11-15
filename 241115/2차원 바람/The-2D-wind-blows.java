import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int q;
    public static int[][] mat;
    public static int[][] tempMat;
    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        mat = new int[n+2][m+2];
        tempMat = new int[n+2][m+2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            shift(r1, c1, r2, c2);
            //printMat();
            averagify(r1, c1, r2, c2);
        }

        printMat();
    }

    public static void printMat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sb.append(mat[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void shift(int r1, int c1, int r2, int c2) {
        int temp = mat[r1][c1];

        for (int i = r1; i < r2; i++) {
            mat[i][c1] = mat[i+1][c1];
        }

        for (int i = c1; i < c2; i++) {
            mat[r2][i] = mat[r2][i+1];
        }

        for (int i = r2; i > r1; i--) {
            mat[i][c2] = mat[i-1][c2];
        }

        for (int i = c2; i > c1+1; i--) {
            mat[r1][i] = mat[r1][i-1];
        }

        mat[r1][c1+1] = temp;
    }

    public static void averagify(int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = mat[i][j];
                int count = 1;

                for (int dir = 0; dir < 4; dir++) {
                    if (inRange(i + dr[dir], j + dc[dir])) {
                        sum += mat[i+dr[dir]][j+dc[dir]];
                        count++;
                    }
                }

                tempMat[i][j] = sum / count;
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                mat[i][j] = tempMat[i][j];
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= m;
    }
}