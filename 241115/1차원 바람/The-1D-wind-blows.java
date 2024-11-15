import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int q;
    public static int[][] mat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            char dir = st.nextToken().charAt(0);
            int dirInt;

            if (dir == 'R') {
                dirInt = -1;
            } else {
                dirInt = 1;
            }

            shift(row, dirInt);

            for (int j = row-1; j >= 0; j--) {
                if (isDuplicateRow(j, j+1)) {
                    dirInt *= -1;
                    shift(j, dirInt);
                } else {
                    break;
                }
            }

            if (dir == 'R') {
                dirInt = -1;
            } else {
                dirInt = 1;
            }
            
            for (int j = row+1; j < n; j++) {
                if (isDuplicateRow(j, j-1)) {
                    dirInt *= -1;
                    shift(j, dirInt);
                } else {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void shiftLeft(int r) {
        int temp = mat[r][0];

        for (int i = 0; i < m-1; i++) {
            mat[r][i] = mat[r][i+1];
        }

        mat[r][m-1] = temp;
    }

    public static void shiftRight(int r) {
        int temp = mat[r][m-1];

        for (int i = m-1; i > 0; i--) {
            mat[r][i] = mat[r][i-1];
        }

        mat[r][0] = temp;
    }

    public static void shift (int r, int dir) {
        if (dir == -1) {
            shiftLeft(r);
        } else {
            shiftRight(r);
        }
    }

    public static boolean isDuplicateRow(int r1, int r2) {
        for (int i = 0; i < m; i++) {
            if (mat[r1][i] == mat[r2][i]) return true;
        }

        return false;
    }
}