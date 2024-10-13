import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        int temp;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-2; j++){
                for (int k = i; k < n; k++){
                    for (int l = 0; l < n-2; l++){
                        if (i == k && (j - l) < 3) continue;
                        temp = mat[i][j] + mat[i][j+1] + mat[i][j+2] + mat[k][l] + mat[k][l+1] + mat[k][l+2];

                        max = Math.max(temp, max);
                    }
                }
            }
        }

        System.out.println(max);
    }
}