import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] mat = new int[MAX_NUM*2][MAX_NUM*2];

        int x1, y1, x2, y2;
        boolean isBlue = false;
        for (int i = 0; i < n; i++) {
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            if (isBlue){
                for (int j = x1 + 100; j < x2 + 100; j++){
                    for (int k = y1 + 100; k < y2 + 100; k++){
                        mat[j][k] = 1;
                    }
                }
            }
            isBlue = !isBlue;
        }

        int count = 0;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[j][k]==1) count++;
            }
        }

        System.out.println(count);
    }
}