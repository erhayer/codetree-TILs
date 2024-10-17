import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 0, cnt;
        for (int k = 1; k <= 100; k++) {
            cnt = 0;
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if (arr[j] - k == k - arr[i]) cnt++;
                }
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}