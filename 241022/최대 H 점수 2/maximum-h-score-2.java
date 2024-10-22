import java.util.Scanner;

public class Main {
    public static final int MAX_X = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int h = MAX_X; h >= 0; h--) {
            int overH = countOverH(arr, h);
            int underH = countUnderH(arr, h);

            if(overH >= h) {
                System.out.println(h);
                break;
            } else {
                if (h - overH <= l && h - overH <= underH) {
                    System.out.println(h);
                    break;
                }
            }
        }
    }

    public static int countOverH(int[] arr, int h) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= h) count++;
        }

        return count;
    }

    public static int countUnderH(int[] arr, int h) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == h-1) count++;
        }

        return count;
    }
}