import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int index, sum;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            index = i;
            sum = 0;

            for (int j = 0; j < m; j++) {
                sum += arr[index];
                index = arr[index];
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}