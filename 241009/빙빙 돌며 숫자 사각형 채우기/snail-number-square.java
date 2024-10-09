import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] mat = new int[n][m];
        int r = 0, c = 0, dir = 1;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        
        int cnt = 1;
        int num = 1;
        mat[0][0] = 1;
        int tr, tc;
        while (cnt < n*m){
            tr = r + dr[dir];
            tc = c + dc[dir];
            if (inRange(tr, tc) && mat[tr][tc] == 0){
                r = tr;
                c = tc;
                mat[r][c] = ++num;
                cnt++;
            } else {
                dir = (dir + 1) % 4;
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean inRange(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}