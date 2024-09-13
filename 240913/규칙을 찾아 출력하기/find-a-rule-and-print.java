import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("*").append(" ");
        }
        sb.append("\n");

        for (int i = 1; i < n-1; i++) {
            for (int j = 0; j < i; j++) {
                sb.append("*").append(" ");
            }
            for (int j = 0; j < 2*n-2-i*2; j++) {
                sb.append(" ");
            }
            sb.append("*\n");
        }
        if (n>1) {
            for (int i = 0; i < n; i++) {
                sb.append("*").append(" ");
            }
        }
        System.out.println(sb);
    }
}