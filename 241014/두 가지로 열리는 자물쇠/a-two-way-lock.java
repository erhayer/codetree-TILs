import java.util.Scanner;

public class Main {
    public static int n;
    public static int a1, b1, c1, a2, b2, c2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a1 = sc.nextInt();
        b1 = sc.nextInt();
        c1 = sc.nextInt();
        a2 = sc.nextInt();
        b2 = sc.nextInt();
        c2 = sc.nextInt();

        int cnt = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                for (int k = 1; k <= n; k++){
                    if (isKey(i, j, k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
    
    public static boolean isKey(int x, int y, int z) {
        return isKey1(x, y, z) || isKey2(x, y, z);
    }

    public static boolean isKey1(int x, int y, int z) {
        if (distance(x, a1) > 2) return false;
        if (distance(y, b1) > 2) return false;
        if (distance(z, c1) > 2) return false;
        return true;
    }

    public static boolean isKey2(int x, int y, int z) {
        if (distance(x, a2) > 2) return false;
        if (distance(y, b2) > 2) return false;
        if (distance(z, c2) > 2) return false;
        return true;
    }

    public static int distance(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        return Math.min(big - small, n + small - big);
    }
}