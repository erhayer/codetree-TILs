import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();
        int[][] students = new int[n][2];

        for (int i = 0; i < n; i++) {
            students[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int[] arr_priceSum = new int[n];
        int max = 0;
        int temp_b, cnt;
        for (int i = 0; i < n; i++) {
            temp_b = b;

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    arr_priceSum[j] = students[j][0]/2 + students[j][1];
                } else {
                    arr_priceSum[j] = students[j][0] + students[j][1];
                }
            }

            Arrays.sort(arr_priceSum);

            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (temp_b >= arr_priceSum[j]) {
                    cnt++;
                    temp_b -= arr_priceSum[j];
                } else {
                    break;
                }
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}