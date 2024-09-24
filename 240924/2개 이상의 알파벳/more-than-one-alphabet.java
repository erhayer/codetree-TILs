import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (isSame(a)){
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
    public static boolean isSame(String str){
        char temp = str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) != temp) return false;
        }
        return true;
    }
}