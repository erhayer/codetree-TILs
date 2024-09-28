import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }   
    }
}