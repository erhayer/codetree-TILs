import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp;
        int sum = 0;
        int count = 0;
        while(true){
            temp = Integer.parseInt(br.readLine());
            if (temp >=30 || temp < 20) break;
            sum += temp;
            count++;
        }
        System.out.printf("%.2f%n", (double) sum / count);
    }
}