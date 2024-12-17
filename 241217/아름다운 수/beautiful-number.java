import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(countBeautifulNumber(n, 0));
    }

    public static int countBeautifulNumber(int n, int len) {
        if (len > n) {
            return 0;
        }
        if (len == n) {
            return 1;
        }

        int count = 0;
        for (int i = 1; i <= 4; i++) {
            count += countBeautifulNumber(n, len + i);
        }

        return count;
    }
}