import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int posA = 0;
        int posB = 0;
        int timeA = 0;
        int timeB = 0;
        int[] timelineA = new int[1000000+1];
        int[] timelineB = new int[1000000+1];

        int v, t;
        for (int i = 0; i < n; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                posA += v;
                timeA++;

                timelineA[timeA] = posA;
            }
        }
        for (int i = 0; i < m; i++) {
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++) {
                posB += v;
                timeB++;

                timelineB[timeB] = posB;
            }
        }

        long status = 0;
        long tempStatus;
        int cnt = 0;
        for (int i = 1; i <= timeA; i++) {
            tempStatus = timelineA[i] - timelineB[i];
            if (status == 0) {
                status = tempStatus;
            } else if (status * tempStatus < 0) {
                cnt++;
                status = tempStatus;
            }
        }

        System.out.println(cnt);
    }
}