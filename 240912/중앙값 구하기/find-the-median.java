import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a>b){
            if (a>c){
                System.out.println(b>c?b:c);
            } else {
                System.out.println(a);
            }
        } else {
            if (c>b){
                System.out.println(b);
            } else {
                System.out.println(a>c?a:c);
            }
        }
    }
}