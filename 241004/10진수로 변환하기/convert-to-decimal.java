import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bin = sc.next();
        int num = 0;
        for (int i = 0; i < bin.length(); i++){
            num = num*2 + bin.charAt(i) - 48;
        }

        System.out.println(num);
    }
}