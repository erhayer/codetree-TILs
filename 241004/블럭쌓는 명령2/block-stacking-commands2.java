import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n+1];
        for (int i=1; i<n+1; i++) arr[i] = 0;
        int a, b;
        for (int i=0; i<k; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            for (int j = a; j <= b; j++) arr[j]++;
        }
        int max = 0;
        for (int i=1; i<n+1; i++) {
            if (arr[i] > max) max = arr[i];
        }

        System.out.println(max);
    }
}