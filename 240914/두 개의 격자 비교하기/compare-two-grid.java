import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] mat1 = new int[n][m];
        int[][] mat2 = new int[n][m];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                mat1[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++){
                mat2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] matr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat1[i][j] == mat2[i][j]){
                    matr[i][j] = 0;
                } else {
                    matr[i][j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sb.append(matr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}