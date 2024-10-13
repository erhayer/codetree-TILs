import java.util.Scanner;

public class Main {
    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        char[][] mat = new char[n][m];
        String temp;
        for (int i = 0; i < n; i++){
            temp = sc.next();
            for (int j = 0; j < m; j++){
                mat[i][j] = temp.charAt(j);
            }
        }

        int[] dr = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
        int[] dc = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
        int r = 0;
        int c = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (mat[i][j] == 'L'){
                    for (int dir = 0; dir < 8; dir++){
                        if (inRange(i+dr[dir], j+dc[dir]) && mat[i+dr[dir]][j+dc[dir]] == 'E' && inRange(i+2*dr[dir], j+2*dc[dir]) && mat[i+2*dr[dir]][j+2*dc[dir]] == 'E'){
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}