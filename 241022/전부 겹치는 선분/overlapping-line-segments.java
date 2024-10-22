import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();

        boolean f = true;
        int x3, x4;
        for (int i = 1; i < n; i++) {
            x3 = sc.nextInt();
            x4 = sc.nextInt();

            if (!isIntersecting(x1, x2, x3, x4)) {
                f = false;
                break;
            } else {
                x1 = Math.max(x1, x3);
                x2 = Math.min(x2, x4);
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