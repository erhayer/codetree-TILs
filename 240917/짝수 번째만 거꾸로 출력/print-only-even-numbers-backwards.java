import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = str.length()%2==0 ? str.length() - 1 : str.length() - 2; i >= 0; i -= 2){
            System.out.print(str.charAt(i));
        }
    }
}