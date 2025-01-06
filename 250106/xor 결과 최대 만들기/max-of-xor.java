import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[] arr;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMax(0, 0, 0);

        System.out.println(max);
    }

    public static void findMax(int cnt, int idx, int currVal) {
        if (cnt >= m) {
            max = Math.max(currVal, max);

            return;
        }

        for (int i = idx; i < n - m + 1 + cnt; i++) {
            findMax(cnt + 1, i + 1, currVal ^ arr[i]);
        }
    }
}