import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            lines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int cross = 1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cross = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                if (isCross(lines[i], lines[j])) {

                    //System.out.println(i + " " + j);
                    cross = 0;
                    break;
                }
            }

            //System.out.println(i + " " + cross);
            cnt += cross;
        }

        System.out.println(cnt);
    }

    public static boolean isCross(int[] line1, int[] line2) {
        if (line1[0] < line2[0]) {
            if (line1[1] > line2[1]) return true;
        } else {
            if (line1[1] < line2[1]) return true;
        }

        return false;
    }
}