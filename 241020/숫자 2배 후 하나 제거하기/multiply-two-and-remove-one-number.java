import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int temp;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] *= 2;
            
            for (int j = 0; j < n; j++) {
                temp = 0;

                for (int k = 0; k < n-1; k++) {
                    if (j == k) continue;
                    if (k == j-1) {
                        if (k == n-2) continue;
                        temp += Math.abs(arr[k] - arr[k+2]);
                    } else {
                        temp += Math.abs(arr[k] - arr[k+1]);
                    }
                    //System.out.println(k + " " + temp);
                }

                min = Math.min(temp, min);
            }
            arr[i] /= 2;
        }

        System.out.println(min);
    }
}