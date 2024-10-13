import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_X = 100;
    public static char[] arr = new char[MAX_X];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x;
        char gh;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            gh = sc.next().charAt(0);

            arr[x-1] = gh;
        }

        int max = Integer.MIN_VALUE;
        char[] temp;
        for (int i = 1; i <= MAX_X; i++){
            for (int j = 0; j <= MAX_X-i; j++){
                temp = Arrays.copyOfRange(arr, j, j+i);
                if (isMagic(temp, i)) {
                    max = i-1;
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isMagic(char[] arr, int n) {
        int cnt_g = 0;
        int cnt_h = 0;
        if (!(arr[0] > 'G' && arr[n-1] > 'G')) return false;
        for (int i = 0; i < n; i++){
            if (arr[i] == 'G') cnt_g++;
            if (arr[i] == 'H') cnt_h++;
        }

        if (cnt_g == 0) return true;
        if (cnt_h == 0) return true;
        if (cnt_g == cnt_h) return true;
        return false;
    }
}