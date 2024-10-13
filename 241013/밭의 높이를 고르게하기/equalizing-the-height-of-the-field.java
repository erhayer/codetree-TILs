import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i <= n-t; i++){
            temp = 0;
            for (int j = i; j < i+t; j++){
                temp += Math.abs(arr[j] - h);
            }

            min = Math.min(min, temp);
        }

        System.out.println(min);
    }
}