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
        for (int r1 = 0; r1 < 1; r1++){
            for (int c1 = 0; c1 < 1; c1++){
                t1 = mat[r1][c1];

                for (int r2 = r1+1; r2 < n - 2; r2++){
                    for (int c2 = c1+1; c2 < m - 2; c2++){
                        t2 = mat[r2][c2];

                        if (t1 != t2) {
                            for (int r3 = r2+1; r3 < n - 1; r3++){
                                for (int c3 = c2+1; c3 < m - 1; c3++){
                                    t3 = mat[r3][c3];

                                    if (t2 != t3) {
                                        for (int r4 = r3+1; r4 < n; r4++){
                                            for (int c4 = c3+1; c4 < m; c4++){
                                                t4 = mat[r4][c4];

                                                if (t3 != t4) {
                                                    cnt++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}