import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] arr;

    public static int minJumpCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMinJumpCount(0, 0);

        System.out.println(minJumpCount == Integer.MAX_VALUE ? -1 : minJumpCount);
    }

    public static void findMinJumpCount(int p, int cnt) {
        if (p == n - 1) {
            minJumpCount = Math.min(cnt, minJumpCount);
            return;
        }

        if (p >= n) {
            return;
        }

        for (int i = 1; i <= arr[p]; i++) {
            findMinJumpCount(p + i, cnt + 1);
        }
    }
}