import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int delta = -1;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0'){
                delta = (int)Math.pow(2, str.length() - 1 - i);
                break;
            }
        }

        System.out.println(binToInt(str) + delta);
    }

    public static int binToInt(String bin){
        int sum = 0;
        for (int i = 0; i < bin.length(); i++) {
            sum += Math.pow(2, i) * (bin.charAt(bin.length() - 1 - i) - '0');
        }
        return sum;
    }
}