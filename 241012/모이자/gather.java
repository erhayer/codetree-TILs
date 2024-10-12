import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < n; i++){
            temp = 0;
            for (int j = 0; j < n; j++) {
                temp += Math.abs(i-j)*arr[j];
            }
            if (temp < min) min = temp;
        }

        System.out.println(min);
    }
}