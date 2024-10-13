import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++) {
                temp = sum - arr[i] - arr[j];
                min = Math.min(Math.abs(s - temp), min);
            }
        }

        System.out.println(min);
    }
}