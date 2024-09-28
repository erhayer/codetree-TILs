import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[2*n];
        for (int i = 0; i < 2*n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = 0;
        int temp;
        for (int i = 0; i < n; i++){
            temp = arr[i] + arr[2*n - i - 1];
            if (temp > max) max = temp;
        }
        System.out.println(max);
    }
}