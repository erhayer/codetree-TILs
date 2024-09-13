import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 4; i++) {
            for (int j = b; j >= a; j--) {
                sb.append(j + " * " + i*2 + " = " + j*i*2);
                if (j>a) {
                    sb.append(" / ");
                } else {
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}