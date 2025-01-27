import java.util.Scanner;

public class Main {
    public static int n;
    

    public static int[] arr;

    public static int[] ascDp;
    public static int[] decDp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        ascDp = new int[n];
        decDp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //fill ascDp
        for (int i = 0; i < n; i++) {
            int len = 1;

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    len = Math.max(len, ascDp[j] + 1);
                }
            }

            ascDp[i] = len;
        }

        //fill decDp
        for (int i = n - 1; i >= 0; i--) {
            int len = 1;

            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    len = Math.max(len, decDp[j] + 1);
                }
            }

            decDp[i] = len;
        }

        int currLen = ascDp[0];
        for (int i = 1; i < n; i++) {
            currLen = Math.max(currLen, ascDp[i]);
            ascDp[i] = currLen;
        }

        currLen = decDp[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            currLen = Math.max(currLen, decDp[i]);
            decDp[i] = currLen;
        }

        int max = decDp[0];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] != arr[j]) {
                    max = Math.max(ascDp[i] + decDp[j], max);
                    break;
                }
            }
        }

        System.out.println(max);
    }
}