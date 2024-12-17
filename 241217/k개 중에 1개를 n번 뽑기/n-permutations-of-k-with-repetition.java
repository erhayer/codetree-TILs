import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] arr = new int[n];
        choose(k, n, 0, arr);
    }

    public static void choose(int k, int n, int idx, int[] arr) {
        if (idx >= n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }

            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr[idx] = i;
            choose(k, n, idx+1, arr);
        }
    }
}