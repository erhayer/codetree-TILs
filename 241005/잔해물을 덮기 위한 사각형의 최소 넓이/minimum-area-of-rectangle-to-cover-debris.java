import java.util.Scanner;

public class Main {
    public static final int MAX_NUM = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] mat = new boolean[MAX_NUM*2][MAX_NUM*2];

        int x1, x2, y1, y2;
        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        for (int j = x1 + MAX_NUM; j < x2 + MAX_NUM; j++){
            for (int k = y1 + MAX_NUM; k < y2 + MAX_NUM; k++){
                mat[j][k] = true;
            }
        }

        x1 = sc.nextInt();
        y1 = sc.nextInt();
        x2 = sc.nextInt();
        y2 = sc.nextInt();
        for (int j = x1 + MAX_NUM; j < x2 + MAX_NUM; j++){
            for (int k = y1 + MAX_NUM; k < y2 + MAX_NUM; k++){
                mat[j][k] = false;
            }
        }

        System.out.println((findMaxX(mat) - findMinX(mat))*(findMaxY(mat) - findMinY(mat)));
    }

    public static int findMinX(boolean[][] mat){
        int min = -1;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[j][k]) min = j;
            }
            if (min != -1) break;
        }

        return min;
    }
    public static int findMinY(boolean[][] mat){
        int min = -1;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[k][j]) min = j;
            }
            if (min != -1) break;
        }

        return min;
    }
    public static int findMaxX(boolean[][] mat){
        int max = -1;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[j][k]) {
                    max = j + 1;
                    break;
                }
            }
        }

        return max;
    }
    public static int findMaxY(boolean[][] mat){
        int max = -1;
        for (int j = 0; j < MAX_NUM*2; j++){
            for (int k = 0; k < MAX_NUM*2; k++){
                if (mat[k][j]) {
                    max = j + 1;
                    break;
                }
            }
        }
        
        return max;
    }
}