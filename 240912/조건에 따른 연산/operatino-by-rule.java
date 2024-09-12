import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (n<1000){
            cnt++;
            if (n%2==0){
                n = n * 3 + 1;
            } else {
                n = n * 2 + 2;
            }
        }
        System.out.println(cnt);
    }
}