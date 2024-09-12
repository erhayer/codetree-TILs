import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if(n>=5){
            System.out.println(n*n);
        } else {
            System.out.println(n*n);
            System.out.println("tiny");
        }
    }
}