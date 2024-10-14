import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++){
            dots[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            boolean init = false;
            int x_min = 0, x_max = 0, y_min = 0, y_max = 0;

            for (int j = 0; j < n; j++){
                if (i == j) continue;
                if (!init) {
                    x_min = dots[j][0];
                    x_max = dots[j][0];
                    y_min = dots[j][1];
                    y_max = dots[j][1];
                    init = true;
                    //System.out.println("!");
                }

                x_min = Math.min(dots[j][0], x_min);
                x_max = Math.max(dots[j][0], x_max);
                y_min = Math.min(dots[j][1], y_min);
                y_max = Math.max(dots[j][1], y_max);

                //System.out.println(x_min + " " + x_max + " " + y_min + " " + y_max);
            }

            //System.out.println((x_max - x_min) * (y_max - y_min));

            min = Math.min((x_max - x_min) * (y_max - y_min), min);
        }

        System.out.println(min);
    }
}