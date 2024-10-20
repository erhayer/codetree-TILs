import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++) {
            dots[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int[] temp;
        int min = Integer.MAX_VALUE;
        int t;
        for (int x = 2; x <= 98; x += 2) {
            for (int y = 2; y <= 98; y += 2) {
                temp = new int[]{0, 0, 0, 0};
                t = 0;

                for (int i = 0; i < n; i++) {
                    if (dots[i][0] > x) {
                        if (dots[i][1] > y) {
                            temp[0]++;
                        } else {
                            temp[3]++;
                        }
                    } else {
                        if (dots[i][1] > y) {
                            temp[1]++;
                        } else {
                            temp[2]++;
                        }
                    }
                }
                
                for (int i = 0; i < 4; i++) {
                    t = Math.max(temp[i], t);
                }

                min = Math.min(t, min);
            }
        }

        System.out.println(min);
    }
}