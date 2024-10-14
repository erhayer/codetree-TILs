import java.util.Scanner;

public class Main {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] queries = new int[n][3];
        for (int i = 0; i < n; i++) {
            queries[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        int cnt = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (isQueries(queries, i*100+j*10+k)) cnt++;
                }
            }
        }
        
        System.out.println(cnt);
    }

    public static boolean isQueries(int[][] queries, int x) {
        for (int i = 0; i < n; i++) {
            if (!isQuery(queries[i], x))
                return false;
        }

        return true;
    }

    public static boolean isQuery(int[] query, int x) {
        if (countStrike(query[0], x) != query[1]) {
            return false;
        }
        if (countBall(query[0], x) != query[2]) {
            return false;
        }

        return true;
    }

    public static int countStrike(int a, int b) {
        int a1 = a%10;
        a /= 10;
        int a2 = a%10;
        int a3 = a/10;

        int b1 = b%10;
        b /= 10;
        int b2 = b%10;
        int b3 = b/10;

        int cnt = 0;
        if (a1 == b1) cnt++;
        if (a2 == b2) cnt++;
        if (a3 == b3) cnt++;

        return cnt;
    }

    public static int countBall(int a, int b) {
        int a1 = a%10;
        a /= 10;
        int a2 = a%10;
        int a3 = a/10;

        int b1 = b%10;
        b /= 10;
        int b2 = b%10;
        int b3 = b/10;

        int cnt = 0;
        if (a1 == b2 || a1 == b3) cnt++;
        if (a2 == b1 || a2 == b3) cnt++;
        if (a3 == b2 || a3 == b1) cnt++;

        return cnt;
    }
}