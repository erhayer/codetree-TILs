import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int cnt = 0;
        int[] temp;
        for (int i = 1; i <= n; i++){
            temp = new int[i];
            for (int j = 0; j <= n-i; j++){
                for (int k = 0; k < i; k++){
                    temp[k] = arr[j+k];
                }
                if (haveAverage(temp, i)) cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean haveAverage(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }

        if (sum % len != 0) return false;

        int avg = sum / len;

        for (int i = 0; i < len; i++) {
            if (avg == arr[i]) return true;
        }
        return false;
    }
}