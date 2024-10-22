import java.util.Scanner;

public class Main {
    public static final int MAX_H = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum;
        int wallCount;
        for (int i = max(arr, n); i <= MAX_H; i++) {
            wallCount = 0;
            sum = 0;

            for (int j = 0; j < n; j++) {
                sum += arr[j];
                if (sum > i) {
                    sum = arr[j];
                    wallCount++;
                }
            }

            if (wallCount == m-1) {
                System.out.println(i);
                break;
            }
        }
    }

    public static int max(int[] arr, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }
}