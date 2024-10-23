import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        
        for (int i = 0 ; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0 ; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[] delta = new int[n];
        for (int i = 0; i < n; i++) {
            delta[i] = b[i] - a[i];
        }

        int distanceSum = 0;
        for (int i = 0; i < n; i++) {
            if (delta[i] < 0) {
                for (int j = i+1; j < n; j++) {
                    if (delta[j] > 0) {
                        distanceSum += (j-i) * -delta[i];
                        delta[j] -= delta[i];
                        delta[i] = 0;
                    }
                }
            }
        }

        System.out.println(distanceSum);
    }
}