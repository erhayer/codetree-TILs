import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        if (x == 1) {
            System.out.println(1);
        } else {
            int time = 0;

            for (int v = 1; v < 10000; v++) {
                if (x == 0) {
                    break;
                } else if (x < v) {
                    time += 1;
                    break;
                } else if (x < 2*v) {
                    time += 2;
                    break;
                } else {
                    time += 2;
                    x -= 2*v;
                }
            }

            System.out.println(time);
        }
    }
}