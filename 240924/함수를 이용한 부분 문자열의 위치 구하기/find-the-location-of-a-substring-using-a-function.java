import java.util.Scanner;

public class Main {
    public static String str;
    public static String sub;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        sub = sc.next();
        System.out.println(substringIndex());
    }
    public static int substringIndex(){
        for (int i = 0; i < str.length() - sub.length() + 1; i++) {
            if (str.substring(i, i + sub.length()).compareTo(sub) == 0) return i;
        }
        return -1;
    }
}