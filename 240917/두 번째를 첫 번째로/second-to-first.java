import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char first = str.charAt(0);
        char second = str.charAt(1);
        
        for (int i = 0; i < str.length(); i++){
            System.out.print(str.charAt(i)==second ? first : str.charAt(i));
        }
    }
}