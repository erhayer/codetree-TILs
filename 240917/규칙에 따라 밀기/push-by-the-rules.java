import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ins = br.readLine();

        for (int i = 0; i < ins.length(); i++){
            str = shift(str, ins.charAt(i));
        }
        System.out.println(str);
    }
    public static String shift(String str, char instruction){
        if(instruction == 'L'){
            return str.substring(1) + str.charAt(0);
        } else{
            return str.charAt(str.length()-1) + str.substring(0, str.length()-1);
        }
    }
}