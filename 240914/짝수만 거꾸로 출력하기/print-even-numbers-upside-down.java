import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        int temp;
        for (int i = n-1; i >= 0; i--){
            temp = arr[i];
            if (temp%2==0){
                System.out.println(temp + " ");    
            }
                
        }
        
        
    }

}