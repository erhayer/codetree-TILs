import java.util.Scanner;

public class Main {
    public static String query;
    public static int length;
    public static int[] charMapper = new int['z' + 1];
    public static int[] numMapper = new int[26];

    public static int maxResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        query = sc.next();
        length = query.length();

        for (int i = 0; i < 26; i++) {
            numMapper[i] = 'a' + i;
        }

        bruteForce(0);

        System.out.println(maxResult);
    }

    public static int calculate() {
        int result = charMapper[query.charAt(0)];
        
        for (int i = 1; i < length; i = i + 2) {
            char operand = query.charAt(i);
            if (operand == '+') {
                result += charMapper[query.charAt(i + 1)];
            } else if (operand == '-') {
                result -= charMapper[query.charAt(i + 1)];
            } else {
                result *= charMapper[query.charAt(i + 1)];
            }
        }

        return result;
    }

    public static void bruteForce(int num) {
        if (num >= 6) {
            maxResult = Math.max(calculate(), maxResult);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            charMapper[numMapper[num]] = i;
            bruteForce(num + 1);
        }
    }
}