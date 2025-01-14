import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] grid;

    public static boolean[] isChosen;
    public static int min = Integer.MAX_VALUE;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        isChosen = new boolean[n];
        for (int i = 0; i < n; i++) {
            isChosen[i] = false;
        }

        choose(0);

        System.out.println(max);
    }

    public static void choose(int cnt) {
        if (cnt == n) {
            max = Math.max(min, max);
        }

        for (int i = 0; i < n; i++) {
            if (!isChosen[i]) {
                int temp = min;

                min = Math.min(grid[cnt][i], min);
                isChosen[i] = true;
                choose(cnt + 1);

                isChosen[i] = false;
                min = temp;
            }
        }
    }
}