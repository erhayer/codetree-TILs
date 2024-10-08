import java.util.Scanner;

public class Main {
    public static final int MAX_T = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[2*MAX_T+1];
        int[] b = new int[2*MAX_T+1];
        a[0] = 1000000;
        b[0] = 1000000;
        int time_a = 0;
        int time_b = 0;

        int t;
        char d;
        for (int i = 0; i < n; i++){
            t = sc.nextInt();
            d = sc.next().charAt(0);

            for (int j = 0; j < t; j++){
                a[++time_a] = a[time_a-1] +  (d=='R' ? 1 : -1);
            }
        }
        for (int i = time_a + 1; i <= MAX_T; i++){
            a[i] = a[time_a];
        }

        for (int i = 0; i < m; i++){
            t = sc.nextInt();
            d = sc.next().charAt(0);

            for (int j = 0; j < t; j++){
                b[++time_b] = b[time_b-1] +  (d=='R' ? 1 : -1);
            }
        }
        for (int i = time_b + 1; i <= MAX_T; i++){
            b[i] = b[time_b];
        }

        boolean isSamePos = true;
        int cnt = 0;
        for (int i = 1; i <= Math.max(time_a, time_b); i++){
            if (isSamePos) {
                if (a[i] != b[i]){
                    isSamePos = false;
                }
            } else {
                if (a[i] == b[i]){
                    isSamePos = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}