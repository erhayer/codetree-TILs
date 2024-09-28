import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);

        for (int i = 0; i < str.length(); i++){
            System.out.print(arr[i]);
        }
    }
}