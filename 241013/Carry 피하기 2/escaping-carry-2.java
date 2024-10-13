import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //brute force
        int max = -1;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    if (!isCarry(arr[i], arr[j], arr[k]))
                        max = Math.max(max, arr[i]+arr[j]+arr[k]);
                }
            }
        }

        System.out.println(max);
    }
    
    public static boolean isCarry(int a, int b, int c) {
        int idx = 0;
        int temp;
        for (int i = 0; i < 5; i++){
            temp = a % 10 + b % 10 + c % 10;
            if (temp >= 10) return true;

            a /= 10;
            b /= 10;
            c /= 10;
        }
        return false;
    }
}