import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};


        StringBuilder sb = new StringBuilder();
        sb.append(mat[r][c]).append(" ");

        boolean moved = true;
        while (moved) {
            moved = false;

            for (int i = 0; i < 4; i++) {
                if (inRange(r + dr[i], c + dc[i], n) && mat[r + dr[i]][c + dc[i]] > mat[r][c]) {
                    moved = true;
                    
                    r += dr[i];
                    c += dc[i];
                    sb.append(mat[r][c]).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    public static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}