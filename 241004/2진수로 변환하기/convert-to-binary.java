import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int binary_len = 0;

        int[] arr = new int[20];

        int count = 0;
        while (true){
        if (n < 2) {
            arr[count] = n;
            break;
        }
        arr[count++] = n % 2;
        n /= 2;
        }

        for (int i = count; i >= 0; i--){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}