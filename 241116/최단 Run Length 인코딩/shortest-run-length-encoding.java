import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            str = shift(str);

            min = Math.min(runLength(str), min);
        }

        System.out.println(min);
    }

    public static String shift(String str) {
        char temp = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        sb.append(temp);

        return sb.toString();
    }

    public static int runLength(String str) {
        char c = str.charAt(0);
        int currentCount = 1;

        StringBuilder sb = new StringBuilder();

        sb.append(c);
        
        for (int i = 1; i < str.length(); i++) {
            if (c != str.charAt(i)) {
                sb.append(currentCount);

                c = str.charAt(i);
                currentCount = 1;

                sb.append(c);
            } else {
                currentCount++;
            }
        }
        sb.append(currentCount);


        //System.out.println(sb);

        return sb.toString().length();
    }
}