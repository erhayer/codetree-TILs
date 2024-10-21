import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int len = 15;
    public static int[] arr = new int[len];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int a=0, b=0, c=0, d=0;
        boolean flag = false;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i+1; j < len - 2; j++) {
                for (int k = j+1; k < len - 1; k++) {
                    for (int m = k+1; m < len; m++) {
                        a = arr[i];
                        b = arr[j];
                        c = arr[k];
                        d = arr[m];

                        int sum = a + b + c + d;

                        if (sum != arr[len-1]) continue;

                        if (arrHas(a+b) && arrHas(a+c) && arrHas(a+d) && arrHas(b+c) && arrHas(b+d) && arrHas(c+d) && arrHas(sum-a) && arrHas(sum-b) && arrHas(sum-c) && arrHas(sum-d)) {
                            flag = true;
                        }

                        if (flag) break;
                    }

                    if (flag) break;
                }

                if (flag) break;
            }

            if (flag) break;
        }

        System.out.println(a + " " + b + " " + c + " " + d);
    }

    public static boolean arrHas(int num) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == num) return true;
        }

        return false;
    }
}