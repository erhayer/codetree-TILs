import java.util.Scanner;

public class Main {
    public static int n;
    public static int k;
    public static int[] arr;
    public static final int MAX_NUM = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] explosionCount = new int[MAX_NUM];
        for (int i = 0; i < n; i++) {
            if(isExplode(i)) explosionCount[arr[i]]++;
        }

        int maxExplosionCount = 0;
        int maxBombNum = 0;
        for (int i = 0; i < MAX_NUM; i++) {
            if (explosionCount[i] > maxExplosionCount) {
                maxExplosionCount = explosionCount[i];
                maxBombNum = i;
            }
        }

        System.out.println(maxBombNum);
    }

    public static boolean isExplode(int i) {
        for (int j = 1; j <= k; j++) {
            if (i-j >= 0 && arr[i] == arr[i-j]) {
                return true;
            }
            if (i+j < n && arr[i] == arr[i+j]) {
                return true;
            }
        }

        return false;
    }
}