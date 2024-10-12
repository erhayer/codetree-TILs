import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        char[][] mat = new char[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }

        int t1, t2, t3, t4;
        int cnt = 0;
        t1 = mat[0][0];
        t4 = mat[n-1][m-1];
        if (t1 != t4){
            for (int i = 1; i < n-2; i++){
                for (int j = 1; j < m-2; j++){
                    t2 = mat[i][j];
                    if (t2 != t1)
                    for (int k = i+1; k < n-1; k++){
                        for (int l = j+1; l < m-1; l++){
                            t3 = mat[k][l];

                            if (t2 != t3) cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}