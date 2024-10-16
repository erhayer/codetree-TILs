import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int b = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] /= 2;
            max = Math.max(countGiftedStudent(arr, b), max);
            arr[i] *= 2;
        }

        System.out.println(max);
    }

    public static int countGiftedStudent(int[] students, int b) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] <= b){
                cnt++;
                b -= students[i];
            } else {
                break;
            }
        }

        return cnt;
    }
}