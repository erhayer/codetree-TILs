import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            if (isPalindrome(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPalindrome(int n) {
        String str = Integer.toString(n);

        for (int i = 0; i < (str.length()/2); i++){
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }

        return true;
    }
}