import java.util.Scanner;

public class Main {
    public static final int MAX_TIME = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        boolean[] timeline = new boolean[MAX_TIME];
        int[][] devs = new int[n][2];
        int a, b;

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            devs[i] = new int[]{a, b};
        }

        int max = Integer.MIN_VALUE;
        int opTime;
        for (int i = 0; i < n; i++) {
            timeline = new boolean[MAX_TIME];
            opTime = 0;

            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                a = devs[j][0];
                b = devs[j][1];

                for (int k = a; k < b; k++) {
                    timeline[k] = true;
                }
            }

            for (int j = 0; j < MAX_TIME; j++) {
                if (timeline[j]) opTime++;
            }

            max = Math.max(opTime, max);
        }

        System.out.println(max);
    }
}