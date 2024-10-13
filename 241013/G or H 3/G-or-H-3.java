import java.util.Scanner;

public class Main {
    public static final int MAX_X = 10000;
    public static int n, k;
    public static int[] arr = new int[MAX_X+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int x;
        char gh;
        for (int i = 0; i < n; i++){
            x = sc.nextInt();
            gh = sc.next().charAt(0);

            arr[x] = gh == 'G' ? 1 : 2;
        }

        int max = 0;
        int temp;
        for (int i = 1; i <= MAX_X-k-1; i++){
            temp = 0;
            for (int j = i; j <= i + k; j++) {
                temp += arr[j];
            }

            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}