import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printRectacgle(Integer.parseInt(br.readLine()));
    }
    public static void printRectacgle(int n){
        int temp = 1;
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (temp == 10){
                    temp = 1;
                }
                sb.append(temp++).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}