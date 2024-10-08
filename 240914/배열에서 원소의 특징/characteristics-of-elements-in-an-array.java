import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        int[] arr = new int[10];
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int t1, t2;

        for (int i = 1; i < 10; i++){
            t1 = arr[i-1];
            t2 = arr[i];
            if (t2%3==0){
                System.out.println(t1);
                break;
            }
        }

    }
}