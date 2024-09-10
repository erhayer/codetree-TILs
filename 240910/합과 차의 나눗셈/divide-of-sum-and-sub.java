import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());
        System.out.printf("%.2f", (n+m)/(n-m));
    }
}