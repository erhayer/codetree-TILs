import java.util.Scanner;

public class Main {
    public static final int MAX_HEIGHT = 100;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= MAX_HEIGHT-17; i++) {
            int cost = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] < i || arr[j] > i+17) {
                    cost += Math.min((arr[j] - i) * (arr[j] - i), (arr[j] - (i + 17)) * (arr[j] - (i + 17)));
                }
            }

            minCost = Math.min(cost, minCost);
        }

        System.out.println(minCost);
    }
}