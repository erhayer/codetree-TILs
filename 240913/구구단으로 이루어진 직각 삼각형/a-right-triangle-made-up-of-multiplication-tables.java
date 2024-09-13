import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n + 1 - i; j++) {
                sb.append(i + " * " + j + " = " + i*j);
                if (j<n+1-i){
                    sb.append(" / ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}