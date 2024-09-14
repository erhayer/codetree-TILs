import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] matrix = new int[4][4];
        StringTokenizer st;

        for (int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                if (i>=j){
                    sum += matrix[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}