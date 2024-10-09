import java.util.Scanner;

public class Main {
    public static int[][] mat;
    public static int n;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        mat = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                cnt += haveOnes(i, j);
            }
        }

        System.out.println(cnt);
    }  
    public static int haveOnes(int r, int c){
        int nr, nc;
        int cnt = 0;
        for (int dirNum = 0; dirNum < 4; dirNum++){
            nr = r + dr[dirNum];
            nc = c + dc[dirNum];
            if (inRange(nr, nc) && mat[nr][nc] == 1) cnt++;
        }

        return cnt >= 3 ? 1 : 0;
    }
    public static boolean inRange(int r, int c){
        return r >= 0 && r < n && c >= 0 && c < n;
    } 
}