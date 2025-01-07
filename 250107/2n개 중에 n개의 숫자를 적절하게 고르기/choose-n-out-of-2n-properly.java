import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] arr;
    public static int minDiff = Integer.MAX_VALUE;
    public static int totalSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            int temp = sc.nextInt();
            totalSum += temp;
            arr[i] = temp;
        }

        choose(0, -1, 0);

        System.out.println(minDiff);
    }

    public static void choose(int cnt, int idx, int sum) {
        if (cnt == n) {
            minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * sum));
            return;
        }

        for (int i = idx + 1; i < n + 1 + cnt; i++) {
            choose(cnt + 1, i, sum + arr[i]);
        }
    }
}