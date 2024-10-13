import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] checkpoints = new int[n][2];

        for (int i = 0; i < n; i++){
            checkpoints[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 1; i < n-1; i++){
            temp = 0;

            for (int j = 0; j < n-1; j++){
                if (j+1 == i) {
                    temp += calDis(checkpoints[j], checkpoints[j+2]);
                } else if (j == i) {
                    continue;
                } else {
                    temp += calDis(checkpoints[j], checkpoints[j+1]);
                }
            }

            if (temp < min) min = temp;
        }

        System.out.println(min);
    }

    public static int calDis(int[] c1, int[] c2) {
        return Math.abs(c1[0] - c2[0]) + Math.abs(c1[1] - c2[1]);
    }
}