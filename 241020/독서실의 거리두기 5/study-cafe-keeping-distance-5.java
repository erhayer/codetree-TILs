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

            arr[i] = 1;
            max = Math.max(distance(arr, n), max);
            arr[i] = 0;
        }

        System.out.println(max);
    }

    public static int distance(int[] arr, int n) {
        boolean init = false;
        int temp = 0;
        int min = n;
        for (int i = 0; i < n; i++) {
            if (init) {
                temp++;
                if (arr[i] == 1) {
                    min = Math.min(temp, min);
                    temp = 0;
                }
            } else {
                if (arr[i] == 1) init = true;
            }
        }

        return min;
    }
}