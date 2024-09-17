import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) <= 'Z'){
                System.out.print((char)(str.charAt(i) + 'a' - 'A'));
            } else {
                System.out.print((char)(str.charAt(i) - 'a' + 'A'));
            }
        }
    }
}