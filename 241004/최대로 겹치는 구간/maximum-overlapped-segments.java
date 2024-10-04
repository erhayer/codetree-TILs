import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[200];

        for (int i = 0; i <200; i++){
            arr[i] = 0;
        }

        int x1, x2;
        for (int i = 0; i < n; i++){
            x1 = sc.nextInt();
            x2 = sc.nextInt();

            for (int j = 0; j < x2; j++) arr[j]++;
        }

        int max = 0;

        for (int i = 0; i < 200; i++) {
            if (arr[i] > max) max = arr[i];
        }

        System.out.println(max);
    }
}