import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = sc.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) continue;
            for (int j = 0; j < n; j++) {
                if (arr[j] == 1) continue;

                arr[i] = 1;
                arr[j] = 1;

                max = Math.max(calculateMinDistance(arr, n), max);

                arr[i] = 0;
                arr[j] = 0;
            }
        }

        System.out.println(max);
    }

    public static int calculateMinDistance(int[] arr, int n) {
        boolean init = false;
        int distance = 0;
        int minDistance = n;
        for (int i = 0; i < n; i++) {
            distance++;

            if (init) {
                if (arr[i] == 1) {
                    minDistance = Math.min(distance, minDistance);
                    distance = 0;
                }

            } else {
                if (arr[i] == 1) init = true;
                distance = 0;
            }
        }

        return minDistance;
    }
}