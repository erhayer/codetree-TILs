import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();

        boolean f = true;
        for (int i = 1; i < n; i++) {
            if (!isIntersecting(x1, x2, sc.nextInt(), sc.nextInt())) {
                f = false;
                break;
            }
        }

        if (f) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean isIntersecting(int x1, int x2, int x3, int x4) {
        return  !(x3 > x2 || x1 > x4);
    }
}