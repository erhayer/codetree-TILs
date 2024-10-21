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

        int dist;
        boolean isMin = false;
        for (int i = 100; i >= arr[0]; i--) {
            dist = 0;
            for (int j = 1; j < n; j++) {
                dist++;

                if (arr[j] <= i) {
                    if (dist > k) {
                        isMin = true;
                        break;
                    }
                    dist = 0;
                }
            }

            if (isMin) {
                System.out.println(i+1);
                break;
            }

            if (i == arr[0]) {
                System.out.println(i);
                break;
            }
        }
    }
}