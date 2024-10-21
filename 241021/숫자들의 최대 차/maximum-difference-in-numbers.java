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

        int maxCount = 0;
        int tempCount;
        for (int i = 0; i < n; i++) {
            tempCount = 0; 
            for (int j = 0; j < n; j++) {
                if (arr[j] >= arr[i] && arr[j] <= arr[i] + k) tempCount++;
            }

            maxCount = Math.max(tempCount, maxCount);
        }

        System.out.println(maxCount);
    }
}