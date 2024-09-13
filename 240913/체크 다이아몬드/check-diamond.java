import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean ind = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i-1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2*i+1; j++) {
                if (ind){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
                ind = !ind;
            }
            ind = true;
            sb.append("\n");
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < n-i-1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < 2*i+1; j++) {
                if (ind){
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
                ind = !ind;
            }
            ind = true;
            sb.append("\n");
        }

        System.out.println(sb);
    }
}