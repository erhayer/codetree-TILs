import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minRow = n-1;
        for (int c = k; c < k+m; c++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][c] == 1) {
                    minRow = Math.min(minRow, i-1);
                    break;
                }
            }
        }

        for (int c = k; c < k+m; c++) {
            mat[minRow][c] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}