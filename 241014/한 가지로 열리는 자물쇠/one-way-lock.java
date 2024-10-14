import java.util.Scanner;

public class Main {
    public static int a, b, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();

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
        if (Math.abs(x - a) <= 2) return true;
        if (Math.abs(y - b) <= 2) return true;
        if (Math.abs(z - c) <= 2) return true;
        return false;
    }
}