import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] seq;
    public static boolean isFound = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        seq = new int[n];

        choose(0);
    }

    public static void choose(int pos) {
        if (isFound) {
            return;
        }
        if (pos >= n) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append(seq[i]);
            }

            System.out.println(sb);

            isFound = true;
            return;
        }

        seq[pos] = 4;
        if (isPossible(pos)) {
            choose(pos + 1);
        }

        seq[pos] = 5;
        if (isPossible(pos)) {
            choose(pos + 1);
        }

        seq[pos] = 6;
        if (isPossible(pos)) {
            choose(pos + 1);
        }
    }

    public static boolean isPossible(int pos) {
        for (int i = 1; i <= (pos + 1) / 2; i++) {
            boolean temp = false;

            for (int j = 0; j < i; j++) {
                if (seq[(pos - 2*i + 1) + j] != seq[(pos - i + 1) + j]) {
                    temp = true;
                }
            }

            if (!temp) {
                return false;
            }
        }

        return true;
    }
}