import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[][] games = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++){
                games[i][sc.nextInt()-1] = j;
            }
        }

        int cnt = 0;
        boolean temp;
        int isSame;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++){
                temp = games[0][i] > games[0][j];
                isSame = 1;

                for (int l = 1; l < k; l++){
                    if (temp != (games[l][i] > games[l][j])) {
                        isSame = 0;
                        break;
                    }
                }

                cnt += isSame;
            }
        }

        System.out.println(cnt);
    }
}