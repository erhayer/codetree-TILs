import java.util.Scanner;
import java.util.Arrays;

class Line implements Comparable<Line>{
    int x1;
    int x2;

    public Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Line o) {
        return this.x1 - o.x1;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lines);

        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int len = 1;
            for (int j = 0; j < i; j++) {
                if (lines[j].x2 < lines[i].x1) {
                    len = Math.max(len, dp[j] + 1);
                }
            }

            dp[i] = len;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}