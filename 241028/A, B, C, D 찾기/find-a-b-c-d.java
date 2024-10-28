import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[15];

        for (int i = 0; i < 15; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + (arr[14] - arr[0] - arr[1] - arr[2]));
    }
}