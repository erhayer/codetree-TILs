import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_NUM = 100;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] mat = new boolean[MAX_NUM*2][MAX_NUM*2];

        int x, y;
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) + MAX_NUM;
            y = Integer.parseInt(st.nextToken()) + MAX_NUM;

            for (int j = x - 8; j < x; j++){
                for (int k = y; k < y + 8; k++){
                    mat[j][k] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < MAX_NUM*2; i++){
            for (int j = 0; j < MAX_NUM*2; j++){
                if (mat[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}