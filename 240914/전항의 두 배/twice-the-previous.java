import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        int[] arr = new int[10];

        arr[0] = a1;
        arr[1] = a2;

        for (int i = 2; i < 10; i++){
            arr[i] = arr[i-1] + 2*arr[i-2];
        }
        for (int i = 0; i < 10; i++){
            System.out.print(arr[i] + " ");
        }
    }
}