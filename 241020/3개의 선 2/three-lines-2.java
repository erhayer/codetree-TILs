import java.util.Scanner;

public class Main {
    public static final int MAX_X = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[][] mat = new int[MAX_X+1][MAX_X+1];
        int[][] temp = new int[MAX_X+1][MAX_X+1];
        int[][] dots = new int[n][2];
        int x, y;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            dots[i] = new int[]{x, y};
            mat[x][y] = 1;
        }

        int isPossible = 0;
        
        //row3
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    matCopy(temp, mat);

                    int r1 = dots[i][0];
                    int r2 = dots[j][0];
                    int r3 = dots[k][0];

                    for (int l = 0; l < MAX_X; l++) {
                        temp[r1][l] = 0;
                        temp[r2][l] = 0;
                        temp[r3][l] = 0;
                    }

                    if (isZero(temp)) isPossible = 1;
                }
            }
        }

        //column3
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    matCopy(temp, mat);

                    int c1 = dots[i][1];
                    int c2 = dots[j][1];
                    int c3 = dots[k][1];

                    for (int l = 0; l < MAX_X; l++) {
                        temp[l][c1] = 0;
                        temp[l][c2] = 0;
                        temp[l][c3] = 0;
                    }

                    if (isZero(temp)) isPossible = 1;
                }
            }
        }

        //row 2, column 1
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    matCopy(temp, mat);

                    int r1 = dots[i][0];
                    int r2 = dots[j][0];
                    int c1 = dots[k][1];

                    for (int l = 0; l < MAX_X; l++) {
                        temp[r1][l] = 0;
                        temp[r2][l] = 0;
                        temp[l][c1] = 0;
                    }

                    if (isZero(temp)) isPossible = 1;
                }
            }
        }

        //row 1, column 2
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    matCopy(temp, mat);

                    int c1 = dots[i][1];
                    int c2 = dots[j][1];
                    int r1 = dots[k][0];

                    for (int l = 0; l < MAX_X; l++) {
                        temp[l][c1] = 0;
                        temp[l][c2] = 0;
                        temp[r1][l] = 0;
                    }

                    if (isZero(temp)) isPossible = 1;
                }
            }
        }

        System.out.println(isPossible);
    }

    public static boolean isZero(int[][] mat) {
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < MAX_X; j++) {
                if (mat[i][j] > 0) return false;
            }
        }

        return true;
    }

    public static void matCopy(int[][] temp, int[][] mat) {
        for (int i = 0; i <= MAX_X; i++) {
            for (int j = 0; j <= MAX_X; j++) {
                temp[i][j] = mat[i][j];
            }
        }
    }
}