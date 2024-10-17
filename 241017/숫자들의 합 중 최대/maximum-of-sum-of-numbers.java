import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int max = Integer.MIN_VALUE;
        for (int i = x; i <= y; i++) {
            max = Math.max(digitSum(i), max);
        }

        System.out.println(max);
    }

    public static int digitSum(int n) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += n%10;
            n /= 10;
        }

        return sum;
    }
}