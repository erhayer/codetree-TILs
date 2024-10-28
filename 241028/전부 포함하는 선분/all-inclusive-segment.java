import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] lines = new int[n][2];

        for (int i = 0 ; i < n; i++) {
            lines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int min = 100;
        int minX, maxX;
        for (int i = 0; i < n; i++) {
            minX = 100;
            maxX = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                minX = Math.min(lines[j][0], minX);
                maxX = Math.max(lines[j][1], maxX);
            }

            min = Math.min(maxX - minX, min);
        }

        System.out.println(min);
    }
}