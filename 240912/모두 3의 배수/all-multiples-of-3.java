import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 1;
        for (int i = 0; i < 5; i++){
            if (Integer.parseInt(br.readLine())%3!=0){
                t = 0;
                break;
            }
        }
        System.out.println(t);
    }
}