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

        int[] cnt = new int[10];
        for (int i = 0; i<10;i++){
            cnt[i] = 0;
        }
        while(a>1){
           a /= b;
           cnt[a%b]++; 
        }

        int sum = 0;
        for (int i = 0; i<10;i++){
            sum += cnt[i]*cnt[i];
        }

        System.out.println(sum);
    }
}