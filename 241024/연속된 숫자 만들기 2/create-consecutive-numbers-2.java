import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();

        if (Math.abs(x1-x2) == 1 && Math.abs(x2-x3) == 1) {
            System.out.println(0);
        } else if (Math.abs(x1-x2) == 1 || Math.abs(x2-x3) == 1) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}