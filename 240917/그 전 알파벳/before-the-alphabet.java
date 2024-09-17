import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.nextLine().charAt(0);

        if(ch == 'a'){
            System.out.println('z');
        } else{
            System.out.println((char)(ch-1));
        }
    }
}