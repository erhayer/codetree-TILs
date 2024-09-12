import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int odd_count = 0;
        for (int i = 0; i < 5; i++){
            if (Integer.parseInt(br.readLine()) % 2 == 0){
                odd_count++;
            }
        }
        System.out.println(odd_count);
    }
}