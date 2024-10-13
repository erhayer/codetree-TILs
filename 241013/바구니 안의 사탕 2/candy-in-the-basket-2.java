import java.util.Scanner;

public class Main {
    public static final int MAX_X = 100;
    public static int n, k;
    public static int[] arr = new int[MAX_X];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int x;
        int num;
        for (int i = 0; i < MAX_X; i++){
            arr[i] = 0;
        }
        for (int i = 0; i < n; i++){
            num = sc.nextInt();
            x = sc.nextInt();

            arr[x-1] += num;
        }

        int max = 0;
        int temp;
        if (k >= MAX_X/2){
            temp = 0;
            for (int i = 0; i < MAX_X; i++){
                temp += arr[i];
            }
            max = temp;
        } else {
            for (int i = k; i < MAX_X - k; i++){
                temp = 0;
                for (int j = i - k; j <= i + k; j++) {
                    temp += arr[j];
                }

                max = Math.max(temp, max);
            }
        }

        System.out.println(max);
    }
}