import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int ind = 1;
        int max_num = n;
        int min_num = 1;

        for (int i = 0; i < n; i++) {
            if (ind == 1){
                for (int j = 0; j < max_num; j++){
                    sb.append("*");
                }
                ind *= -1;
                max_num--;
            } else {
                for (int j = 0; j < min_num; j++){
                    sb.append("*");
                }
                ind *= -1;
                min_num++;
            }
            sb.append("\n");
        }
        for (int i = n-1; i >= 0; i--) {
            if (ind == 1){
                for (int j = 0; j < max_num; j++){
                    sb.append("*");
                }
                ind *= -1;
                max_num--;
            } else {
                for (int j = 0; j < min_num; j++){
                    sb.append("*");
                }
                ind *= -1;
                min_num++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}