import java.util.Scanner;

public class Main {
    public static int[] month_to_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        System.out.println(dateToNum(c, d) - dateToNum(a, b) + 1);
    }
    public static int dateToNum(int m, int d) {
        int sum = 0;
        for (int i = 1; i < m; i++){
            sum += month_to_days[i];
        }
        return sum + d;
    }
}