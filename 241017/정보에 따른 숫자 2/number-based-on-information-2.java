import java.util.Scanner;

public class Main {
    public static final int MAX_X = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] line = new int[MAX_X+1];

        char alpha;
        int x;
        for (int i = 0; i < t; i++) {
            alpha = sc.next().charAt(0);
            x = sc.nextInt();

            if (alpha == 'S') {
                line[x] = 1;
            } else {
                line[x] = 2;
            }
        }

        int min_s;
        int min_n;
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            min_s = Integer.MAX_VALUE;
            min_n = Integer.MAX_VALUE;

            for (int j = i; j >= 0; j--) {
                if (line[j] == 1) {
                    min_s = Math.min(i-j, min_s);
                }
                if (line[j] == 2) {
                    min_n = Math.min(i-j, min_n);
                }
            }
            for (int j = i; j <= MAX_X; j++) {
                if (line[j] == 1) {
                    min_s = Math.min(j-i, min_s);
                }
                if (line[j] == 2) {
                    min_n = Math.min(j-i, min_n);
                }
            }

            if (min_s <= min_n) cnt++;
        }


        System.out.println(cnt);
    }
}