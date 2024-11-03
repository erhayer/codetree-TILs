import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        if (isProper(input)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isProper(String input) {
        Stack<Character> s = new Stack<>();

        char c;
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);

            if (c == '(') {
                s.push(c);
                //System.out.println(1);
            } else {
                if (s.empty()) {
                    //System.out.println(2);
                    return false;
                } else {
                    //System.out.println(3);
                    s.pop();
                }
            }
        }

        if (!s.empty()) {
            //System.out.println(4);
            return false;
        }

        return true;
    }
}