import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ices = new int[n];
        for (int i = 0; i < n; i++) {
            ices[i] = sc.nextInt();
        }

        int cnt;
        int max = 0;
        boolean isIce, temp;
        for (int h = 0; h < 1000; h++) {
            isIce = ices[0] > h;
            temp = ices[0] > h;
            cnt = isIce ? 1 : 0;

            for (int i = 0; i < n; i++) {
                temp = ices[i] > h;

                if (temp != isIce && isIce == false) {
                    cnt++;
                }
                isIce = temp;
            }

            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }
}