import java.util.Scanner;

class PT {
    int s;
    int e;
    int p;

    public PT(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }
}
public class Main {
    public static int n;

    public static PT[] pts;

    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        pts = new PT[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            pts[i] = new PT(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int maxP = pts[i].p;

            for (int j = 0; j < i; j++) {
                if (isOverlaping(pts[i], pts[j])) {
                    maxP = Math.max(dp[j] + pts[i].p, maxP);
                }
            }

            dp[i] = maxP;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

    public static boolean isOverlaping(PT p1, PT p2) {
        return p1.s > p2.e || p1.e < p2.s;
    }
}