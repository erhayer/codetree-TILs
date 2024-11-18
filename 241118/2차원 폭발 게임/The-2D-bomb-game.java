import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static int[][] mat;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int k = sc.nextInt();

        mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            boolean exploded = true;

            while (exploded) {
                exploded = explode();
            }
            
            //print();
            rotate();

            exploded = true;
            while (exploded) {
                exploded = explode();
            }

            //print();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += mat[i][j] == 0 ? 0 : 1;
            }
        }

        System.out.println(count);
    }

    public static void rotate() {
        int[][] temp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = mat[n-1-j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = temp[i][j];
            }
        }

        //print();
        drop();
    }

    public static boolean explode() {
        boolean exploded = false;

        for (int i = 0; i < n; i++) {
            int currNum = 0;
            int start = 0;
            int numCount = 0;

            for (int j = 0; j < n; j++) {
                if (currNum != mat[j][i]) {
                    if (currNum != 0 && numCount >= m) {
                        exploded = true;
                        for (int k = start; k < j; k++) {
                            mat[k][i] = 0;
                        }
                    }

                    currNum = mat[j][i];
                    numCount = 0;
                    start = j;
                }

                numCount++;
            }

            if (currNum != 0 && numCount >= m) {
                exploded = true;
                for (int k = start; k < n; k++) {
                    mat[k][i] = 0;
                }
            }
        }

        //print();
        drop();
        //print();

        return exploded;
    }

    public static void drop() {
        for (int i = 0; i < n; i++) {
            int[] temp = new int[n];
            int index = n-1;
            
            for (int j = n-1; j >= 0; j--) {
                if (mat[j][i] != 0) {
                    temp[index--] = mat[j][i];
                }
            }

            for (int j = 0; j < n; j++) {
                mat[j][i] = 0 + temp[j];
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(" "); 
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}