import java.util.Scanner;

public class Main {
    public static final int MAX_TIME = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[MAX_TIME];
        int[] b = new int[MAX_TIME];
        for (int i = 0; i < MAX_TIME; i++){
            a[i] = 0;
            b[i] = 0;
        }

        int index_a = 0;
        int index_b = 0;
        int pos_a = 0;
        int pos_b = 0;
        
        int v, t;

        for (int i = 0; i < n; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++){
                pos_a += v;
                a[++index_a] = pos_a;
            }
        }

        for (int i = 0; i < m; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++){
                pos_b += v;
                b[++index_b] = pos_b;
            }
        }

        int cnt = 0;
        long temp = 0;
        for (int i = 1; i <= index_a; i++) {
            if (a[i] - b[i] == 0) continue;
            if (temp == 0) {
                temp = a[i] - b[i];
            }
            if (temp*(a[i] - b[i]) < 0) {
                cnt++;
                temp = a[i] - b[i];
            }
        }

        System.out.println(cnt);
    }
}