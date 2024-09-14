import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int odd_or_even = (n-1)%2;
        int temp = 1;
        int[][] mat = new int[n][n];
        for (int i = n-1; i >= 0; i--){
            if (i%2 == odd_or_even){
                for (int j = n-1; j >= 0; j--){
                    mat[j][i] = temp++;
                }
            } else{
                for (int j = 0; j < n; j++){
                    mat[j][i] = temp++;

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}