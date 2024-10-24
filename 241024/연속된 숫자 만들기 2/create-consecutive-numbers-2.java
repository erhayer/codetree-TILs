import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        int x1 = Math.min(Math.min(t1, t2), t3);
        int x3 = Math.max(Math.max(t1, t2), t3);
        int x2 = t1+t2+t3-x1-x3;

        if (Math.abs(x1-x2) == 1 && Math.abs(x2-x3) == 1) {
            System.out.println(0);
        } else if (Math.abs(x1-x2) == 2 || Math.abs(x2-x3) == 2) {
            System.out.println(1);
        } else {
            System.out.println(2);
        }
    }
}