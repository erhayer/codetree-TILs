import java.util.Scanner;

public class Main {
    public static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = -1;
            }
        }

        int r = 0, c = 0, dir = 1;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        int num = 0;
        int tr, tc;
        for (int i = 0; i < n*m; i++){
            mat[r][c] = 'A' + num;
            num = (num+1) % 26; 
            //System.out.println(r + " " + c);
            tr = r + dr[dir];
            tc = c + dc[dir];
            //System.out.println(tr + " " + tc);
            if (!inRange(tr, tc) || mat[tr][tc] != -1) {
                //System.out.println("!");
                dir = (dir + 1) % 4;
            }
            r += dr[dir];
            c += dc[dir];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((char)mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}