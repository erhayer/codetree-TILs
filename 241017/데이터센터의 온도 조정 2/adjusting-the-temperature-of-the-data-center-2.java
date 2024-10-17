import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();

        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = -1; i <= 1001; i++) {
            sum = 0;

            for (int j = 0; j < n; j++) {
                if (i < machines[j][0]) {
                    sum += c;
                } else if (i > machines[j][1]) {
                    sum += h;
                } else {
                    sum += g;
                }
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}