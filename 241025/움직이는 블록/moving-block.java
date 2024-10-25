import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        int sum = 0;

        int input;
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();

            sum += input;
            arr[i] = input;
        }

        int avg = sum/n;

        int moves = 0;

        for (int i = 0; i < n; i++) {
            moves += arr[i] > avg ? arr[i] - avg : 0;
        }

        System.out.println(moves);
    }
}