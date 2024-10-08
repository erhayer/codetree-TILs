import java.util.Scanner;

public class Main{
    public static final int MAX_T = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[MAX_T+1];
        int[] b = new int[MAX_T+1];
        a[0] = 0;
        b[0] = 0;
        int t_a = 0;
        int t_b = 0;

        int v, t;
        for (int i = 0; i < n; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++){
                a[++t_a] = a[t_a-1] + v;
            }
        }
        for (int i = 0; i < m; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for (int j = 0; j < t; j++){
                b[++t_b] = b[t_b-1] + v;
            }
        }
        // for (int i = 0; i < t_a; i++) {
        //     System.out.println(a[i] + " " + b[i]);
        // }

        int aCompareToB = compareAB(a[1], b[1]);
        int cnt = 1;
        int temp;
        for (int i = 2; i <= t_a; i++){
            temp = compareAB(a[i], b[i]);
            if (aCompareToB != temp) {
                cnt += 1;
            }
            //System.out.println(cnt);
        }

        System.out.println(cnt);
    }
    public static int compareAB(int a, int b){
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }
}