import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 =sc.nextInt();
        int x2 =sc.nextInt();
        int x3 =sc.nextInt();
        int x4 =sc.nextInt();

        if (x3 > x2 || x1 > x4) {
            System.out.println("nonintersecting");
        } else {
            System.out.println("intersecting");
        }
    }
}