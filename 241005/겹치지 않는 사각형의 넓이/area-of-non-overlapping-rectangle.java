import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = new int[MAX_NUM*2][MAX_NUM*2];

        int x1, y1, x2, y2;
        for (int i = 0; i < 2; i++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();

            for (int j = x1 + MAX_NUM; j < x2 + MAX_NUM; j++){
                for (int k = y1 + MAX_NUM; k < y2 + MAX_NUM; k++){
                    mat[j][k] = 1;
                }
            }
        }

        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        for (int j = x1 + MAX_NUM; j < x2 + MAX_NUM; j++){
            for (int k = y1 + MAX_NUM; k < y2 + MAX_NUM; k++){
                mat[j][k] = 0;
            }
        }

        int count = 0;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[j][k] == 1) count++;
            }
        }

        System.out.println(count);
    }
}