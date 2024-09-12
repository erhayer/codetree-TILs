import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int t = 1;
        int count = 0;
        while (n > 1){
            n /= t;
            t++;
            count++;
        }
        System.out.println(count);
    }
}