import java.util.Scanner;

public class Main {
    public static final int MAX_X = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cost;
        int minCost = Integer.MAX_VALUE; 
        for (int i = 1; i <= MAX_X; i++) {
            cost = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] > i + k) {
                    cost += arr[j] - (i+k);
                } else if (arr[j] < i) {
                    cost += i - arr[j];
                }
            }

            minCost = Math.min(cost, minCost);
        }

        System.out.println(minCost);
    }
}