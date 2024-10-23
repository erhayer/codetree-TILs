import java.util.Scanner;

public class Main {
    public static final int BIRD_COUNT = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] birds = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        int cnt = 0;
        int bird, pos;
        for (int i = 0; i < n; i++) {
            bird = sc.nextInt();
            pos = sc.nextInt();

            if (birds[bird] != -1 && birds[bird] != pos) {
                cnt++;
            }
            birds[bird] = pos;
        }

        System.out.println(cnt);
    }
}