import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        if (a%3==0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        if (a%5==0){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
    }
}