import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int temp = 9;
        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                if (temp > 1) {
                    sb.append(temp);
                    temp--;
                } else {
                    sb.append(temp);
                    temp = 9;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}