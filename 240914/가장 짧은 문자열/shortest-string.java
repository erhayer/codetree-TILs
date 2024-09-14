import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = 100, max = 0;
        String temp;
        for (int i = 0; i < 3; i++){
            temp = br.readLine();
            if (temp.length() < min) min = temp.length();
            if (temp.length() > max) max = temp.length();
        }
        System.out.println(max-min);
    }
}