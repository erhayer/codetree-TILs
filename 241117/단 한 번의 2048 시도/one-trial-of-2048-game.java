import java.util.Scanner;

public class Main {
    public static int mat[][] = new int[4][4];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        char dir = sc.next().charAt(0);

        shift(dir);

        print();
    }

    public static void spinClockwise() {
        int[][] temp = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = mat[3-j][i];
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mat[i][j] = temp[i][j];
            }
        }
    }

    public static void drop() {
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[4];
            int index = 3;
            for (int j = 3; j >= 0; j--) {
                if (mat[j][i] != 0) {
                    temp[index--] = mat[j][i];
                }
            }

            for (int j = 0; j < 4; j++) {
                mat[j][i] = 0 + temp[j];
            }
        }
    }

    public static void merge() {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (mat[j][i] != 0 && mat[j][i] == mat[j-1][i]) {
                    mat[j][i] *= 2;

                    for (int k = j-1; k > 0; k--) {
                        mat[k][i] = mat[k-1][i];
                    }

                    mat[0][i] = 0;
                }
            }
        }
    }

    public static void shift(char dir) {
        if (dir == 'U') {
            spinClockwise();
            spinClockwise();

            drop();
            merge();

            spinClockwise();
            spinClockwise();
        } else if (dir == 'R') {
            spinClockwise();

            drop();
            merge();

            spinClockwise();
            spinClockwise();
            spinClockwise();
        } else if (dir == 'D') {
            drop();
            merge();
        } else if (dir == 'L') {
            spinClockwise();
            spinClockwise();
            spinClockwise();

            drop();
            merge();

            spinClockwise();
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(mat[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}