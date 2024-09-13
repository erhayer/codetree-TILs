import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = (char) ('A' + i);
        }

        int index = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < 2*n-2*i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i; j++) {
                if (index > 25) {
                    index = 0;
                }
                sb.append(arr[index]).append(" ");
                index++;
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}