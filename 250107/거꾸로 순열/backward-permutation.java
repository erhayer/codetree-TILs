import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] seq;
    public static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        seq = new int[n];
        v = new boolean[n];

        for (int i = 0; i < n; i++) {
            v[i] = false;
        }

        choose(0);
    }

    public static void choose(int cnt) {
        if (cnt == n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(seq[i] + 1).append(" ");
            }

            System.out.println(sb);

            return;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (!v[i]) {
                seq[cnt] = i;
                v[i] = true;

                choose(cnt + 1);

                v[i] = false;
            }
        }
    }
}