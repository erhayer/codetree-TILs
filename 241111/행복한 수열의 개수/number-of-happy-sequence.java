import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int rowSameCount = 0;
            int colSameCount = 0;
            int isRowHappy = 0;
            int isColHappy = 0;
            int beforeRow = -1;
            int beforeCol = -1;

            for (int j = 0; j < n; j++) {
                if (mat[i][j] != beforeRow) {
                    rowSameCount = 1;
                    beforeRow = mat[i][j];
                } else {
                    rowSameCount++;
                }

                if (rowSameCount >= m) {
                    isRowHappy = 1;
                }


                if (mat[j][i] != beforeCol) {
                    colSameCount = 1;
                    beforeCol = mat[j][i];
                } else {
                    colSameCount++;
                }

                if (colSameCount >= m) {
                    isColHappy = 1;
                }
            }

            count += isColHappy + isRowHappy;
        }


        System.out.println(count);
    }
}