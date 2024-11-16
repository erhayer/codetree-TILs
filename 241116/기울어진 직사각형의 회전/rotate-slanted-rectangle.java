import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[][] mat;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        mat = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int m3 = Integer.parseInt(st.nextToken());
        int m4 = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        spin(r-1, c-1, m1, m2, m3, m4, dir);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(" ");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void spin(int r, int c, int m1, int m2, int m3, int m4, int dir) {
        int[] dr = new int[]{-1, -1, 1, 1};
        int[] dc = new int[]{1, -1, -1, 1};

        int temp = mat[r][c];

        int before;
        int rowPos = r;
        int colPos = c;
        if (dir == 0) {
            for (int i = 0; i < m4; i++) {
                mat[rowPos][colPos] = mat[rowPos-dr[3]][colPos-dc[3]];

                rowPos -= dr[3];
                colPos -= dc[3];
            }
            for (int i = 0; i < m3; i++) {
                mat[rowPos][colPos] = mat[rowPos-dr[2]][colPos-dc[2]];

                rowPos -= dr[2];
                colPos -= dc[2];
            }
            for (int i = 0; i < m2; i++) {
                mat[rowPos][colPos] = mat[rowPos-dr[1]][colPos-dc[1]];

                rowPos -= dr[1];
                colPos -= dc[1];
            }
            for (int i = 0; i < m1; i++) {
                mat[rowPos][colPos] = mat[rowPos-dr[0]][colPos-dc[0]];

                rowPos -= dr[0];
                colPos -= dc[0];
            }

            mat[r+dr[0]][c+dc[0]] = temp;
        } else {
            for (int i = 0; i < m1; i++) {
                mat[rowPos][colPos] = mat[rowPos+dr[0]][colPos+dc[0]];

                rowPos += dr[0];
                colPos += dc[0];
            }
            for (int i = 0; i < m2; i++) {
                mat[rowPos][colPos] = mat[rowPos+dr[1]][colPos+dc[1]];

                rowPos += dr[1];
                colPos += dc[1];
            }
            for (int i = 0; i < m3; i++) {
                mat[rowPos][colPos] = mat[rowPos+dr[2]][colPos+dc[2]];

                rowPos += dr[2];
                colPos += dc[2];
            }
            for (int i = 0; i < m4; i++) {
                mat[rowPos][colPos] = mat[rowPos+dr[3]][colPos+dc[3]];

                rowPos += dr[3];
                colPos += dc[3];
            }

            mat[r-dr[3]][c-dc[3]] = temp;
        }
    }
}