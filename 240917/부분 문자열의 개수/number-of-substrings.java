import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int count = 0;
        for (int i = 0; i < str1.length() - 1; i++){
            if (str1.charAt(i)==str2.charAt(0) && str1.charAt(i+1)==str2.charAt(1)){
                count++;
            }
        }

        System.out.println(count);
    }
}