import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] seq;
    public static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        seq = new int[n];
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            isVisited[i] = false;
        }

        choose(0);
    }

    public static void choose(int cnt) {
        if (cnt == n) {
            printSeq();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                seq[cnt] = i;
                isVisited[i] = true;

                choose(cnt + 1);

                isVisited[i] = false;
            }
        }

    }

    public static void printSeq() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(seq[i] + 1).append(" ");
        }

        System.out.println(sb);
    }
}