import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++){
            matrix[0][i] = 1;
        }
        for(int i = 0; i < n; i++){
            matrix[i][0] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j] + matrix[i][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}