import java.util.Scanner;

public class Main {
    public static int[][] tile = new int[19][19];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //input
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                tile[i][j] = sc.nextInt();
            }
        }

        int[] ans = findOmok();

        if (ans[0] == 0) {
            System.out.println(0);
        } else {
            System.out.println(ans[0]);
            System.out.println(ans[1] + " " + ans[2]);
        }
    }

    public static int[] findOmok() {
        for (int i = 2; i < 17; i++) {
            for (int j = 2; j < 17; j++) {
                if (isReverseDiagonalOmok(i, j)) {
                    return new int[]{tile[i][j], i+1, j+1};
                }
                if (isDiagonalOmok(i, j)) {
                    return new int[]{tile[i][j], i+1, j+1};
                }
            }
        }
        for (int i = 0; i < 19; i++) {
            for (int j = 2; j < 17; j++) {
                if (isHorizontalOmok(i, j)) {
                    return new int[]{tile[i][j], i+1, j+1};
                }
            }
        }
        for (int i = 2; i < 17; i++) {
            for (int j = 0; j < 10; j++) {
                if (isVerticalOmok(i, j)) {
                    return new int[]{tile[i][j], i+1, j+1};
                }
            }
        }
        return new int[]{0, 0, 0};
    }

    public static boolean isHorizontalOmok(int r, int c) {
        if (tile[r][c] == 0) return false;
        for (int i = -2; i < 3; i++){
            if (tile[r][c] != tile[r][c+i]) return false; 
        }
        return true;
    }

    public static boolean isDiagonalOmok(int r, int c) {
        if (tile[r][c] == 0) return false;
        for (int i = -2; i < 3; i++){
            if (tile[r][c] != tile[r+i][c+i]) return false; 
        }
        return true;
    }

    public static boolean isReverseDiagonalOmok(int r, int c) {
        if (tile[r][c] == 0) return false;
        for (int i = -2; i < 3; i++){
            if (tile[r][c] != tile[r-i][c+i]) return false; 
        }
        return true;
    }

    public static boolean isVerticalOmok(int r, int c) {
        if (tile[r][c] == 0) return false;
        for (int i = -2; i < 3; i++){
            if (tile[r][c] != tile[r+i][c]) return false; 
        }
        return true;
    }
}