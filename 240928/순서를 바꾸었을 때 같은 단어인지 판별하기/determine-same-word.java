import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        if (canSame(a, b)) {
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
    public static boolean canSame(String a, String b){
        int len_a = a.length();
        int len_b = b.length();
        if(len_a != len_b) return false;

        char[] arr_a = new char[len_a];
        char[] arr_b = new char[len_b];

        for (int i = 0; i < len_a; i++){
            arr_a[i] = a.charAt(i);
        }
        for (int i = 0; i < len_b; i++){
            arr_b[i] = b.charAt(i);
        }

        Arrays.sort(arr_a);
        Arrays.sort(arr_b);

        for (int i = 0; i < len_a; i++){
            if (arr_a[i] != arr_b[i]) return false;
        }
        return true;
    }
}