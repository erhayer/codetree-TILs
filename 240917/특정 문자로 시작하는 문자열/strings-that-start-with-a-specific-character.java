import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        char finding = br.readLine().charAt(0);
        int count = 0;
        float avg_length = 0;
        for (int i = 0; i < n; i++){
            if (arr[i].charAt(0) == finding) {
                count++;
                avg_length += arr[i].length();
            }
        }
        System.out.println(count + " " + String.format("%.2f", avg_length/count));
    }
}