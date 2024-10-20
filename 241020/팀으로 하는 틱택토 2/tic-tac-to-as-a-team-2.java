import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str;
        int[][] mat = new int[3][3];
        for (int i = 0; i < 3; i++) {
            str = sc.next();
            for (int j = 0; j < 3; j++) {
                mat[i][j] = str.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for (int i = 1; i <= 8; i++) {
            for (int j = i+1; j <= 9; j++) {
                if (canWin(mat, i, j)) {
                    cnt++;
                    //System.out.println(i + " " + j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean canWin(int[][] mat, int a, int b) {
        boolean temp;
        
        //row
        for (int i = 0; i < 3; i++) {
            if (mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2]) continue;

            temp = true;

            for (int j = 0; j < 3; j++) {
                if (mat[i][j] != a && mat[i][j] != b) temp = false;
            }
            if (temp) return true;
        }

        //col
        for (int i = 0; i < 3; i++) {
            if (mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i]) continue;
            temp = true;
            for (int j = 0; j < 3; j++) {
                if (mat[j][i] != a && mat[j][i] != b) temp = false;
            }

            if (temp) return true;
        }

        //diagonal
        temp = true;
        if (!(mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])) {
            for (int j = 0; j < 3; j++) {
                if (mat[j][j] != a && mat[j][j] != b) temp = false;
            }
            if (temp) return true;
        }
        temp = true;
        if (!(mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0])) {
            for (int j = 0; j < 3; j++) {
                if (mat[j][2-j] != a && mat[j][2-j] != b) temp = false;
            }

            if (temp) return true;
        }

        return false;
    }
}