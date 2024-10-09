import java.util.Scanner;

public class Main {
    public static boolean[][] mat;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int m = sc.nextInt();

        mat = new boolean[n][n];

        int r, c;
        for (int i = 0; i < m; i++){
            r = sc.nextInt()-1;
            c = sc.nextInt()-1;
            mat[r][c] = true;

            System.out.println(isComfort(r, c) ? 1 : 0);
        }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++){
        //         System.out.print((mat[i][j] ? 1 : 0) + " ");
        //     }
        //     System.out.println();
        // }
    }

    public static boolean isComfort(int r, int c) {
        int cnt = 0;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        int tr, tc;
        for (int d = 0; d < 4; d++){
            tr = r + dr[d];
            tc = c + dc[d];
            if (inRange(tr, tc) && mat[tr][tc]) {
                cnt++;
            }
        }

        return cnt == 3;
    }
    public static boolean inRange(int r, int c){
        return r>=0&&r<n&&c>=0&&c<n;
    }
}