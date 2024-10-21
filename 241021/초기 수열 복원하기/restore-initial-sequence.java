import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] sumArr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            sumArr[i] = sc.nextInt();
        }

        int first = sumArr[0];

        int[] arr = new int[n];
        for (int i = 1; i < first; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    arr[j] = i;
                } else {
                    arr[j] = sumArr[j-1] - arr[j-1];
                }
            }

            if (isMatch(arr)) break;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static boolean isMatch(int[] arr) {
        return isNotDuplicate(arr) && inRange(arr);
    }

    public static boolean isNotDuplicate(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean inRange(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > n) {
                return false;
            }
        }

        return true;
    }
}