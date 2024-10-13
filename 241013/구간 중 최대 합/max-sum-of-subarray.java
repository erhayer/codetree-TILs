import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int temp;
        int max = -1;
        for (int i = 0; i <= n-k; i++) {
            temp = 0;
            for (int j = i; j < i+k; j++){
                temp += arr[j];
            }

            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}