import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        boolean is_del = false;

        for (int i = 0; i < str.length(); i++){
            if (!is_del){
                if(str.charAt(i)=='e'){
                    is_del = true;
                    continue;
                }
            }
            System.out.print(str.charAt(i));
        }
    }
}