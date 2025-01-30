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
                    len = Math.max(ascDp[j] + 1, len);
                }
            }

            ascDp[i] = len;
        }

        //fill decDp
        for (int i = n - 1; i >= 0; i--) {
            int len = 1;

            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    len = Math.max(decDp[j] + 1, len);
                }
            }

            decDp[i] = len;
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int maxAscLen = 0;
            int maxAscNum = 0;
            int maxDecLen = 0;

            for (int j = 0; j < i; j++) {
                if (ascDp[j] > maxAscLen) {
                    maxAscLen = ascDp[j];
                    maxAscNum = arr[j];
                }
            }

            for (int j = n - 1; j >= i; j--) {
                if (decDp[j] > maxDecLen && arr[j] != maxAscNum) {
                    maxDecLen = decDp[j];
                }
            }

            maxLen = Math.max(maxAscLen + maxDecLen, maxLen);
        }

        System.out.println(maxLen);
    }
}