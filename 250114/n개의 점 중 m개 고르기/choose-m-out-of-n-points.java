import java.util.Scanner;
import java.util.ArrayList;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n;
    public static int m;

    public static int[][] dp;
    public static Pair[] dots;

    public static ArrayList<Integer> chosenDots = new ArrayList<>();

    public static int minDist = Integer.MAX_VALUE;
    public static int localMaxDist = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        dp = new int[n][n];
        dots = new Pair[n];

        for (int i = 0; i < n; i++) {
            dots[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = calDist(dots[i], dots[j]);

                dp[i][j] = dist;
                dp[j][i] = dist;
            }
        }

        choose(0, 0);

        System.out.println(minDist);
    }

    public static int calDist(Pair d1, Pair d2) {
        return (d1.x - d2.x) * (d1.x - d2.x) + (d1.y - d2.y) * (d1.y - d2.y);
    }

    public static void choose(int cnt, int idx) {
        if (cnt == m) {
            minDist = Math.min(minDist, localMaxDist);
            return;
        }

        if (idx >= n) {
            return;
        }

        chosenDots.add(idx);

        int temp = localMaxDist;
        if (cnt != 0) {
            updateLMD(idx);
        }
        choose(cnt + 1, idx + 1);
        
        localMaxDist = temp;
        chosenDots.remove(chosenDots.size() - 1);
        choose(cnt, idx + 1);
    }

    public static void updateLMD(int m) {
        for (int i = 0; i < chosenDots.size(); i++) {
            localMaxDist = Math.max(localMaxDist, calDist(dots[chosenDots.get(i)], dots[m]));
        }
    }
}