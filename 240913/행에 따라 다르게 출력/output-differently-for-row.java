import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (i%2==0){
                for (int j = 0; j < n; j++){
                    sb.append(++temp).append(" ");
                }
            } else {
                for (int j = 0; j < n; j++){
                    temp += 2;
                    sb.append(temp).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}