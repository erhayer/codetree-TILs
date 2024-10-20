import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cntArr = new int[1011];
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            cntArr[Math.min(a,b)*100+Math.max(a,b)]++;
        }

        int min = 0;
        for (int i = 0; i < 1011; i++) {
            min = Math.max(cntArr[i], min);
        }

        System.out.println(min);
    }
}