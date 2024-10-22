import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = sc.nextInt();
        int d = sc.nextInt();

        if (c >= b || a >= d) {
            System.out.println(b-a+d-c);
        } else if (c >= a) {
            if (b >= d) {
                System.out.println(b-a);
            } else {
                System.out.println(b-a + d-c);
            }
        } else {
            if (b > d) {
                System.out.println(d-c + b-d);
            } else {
                System.out.println(d-c);
            }
        }
    }
}