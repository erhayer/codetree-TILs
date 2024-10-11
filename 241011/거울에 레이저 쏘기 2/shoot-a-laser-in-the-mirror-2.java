import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        char[][] mat = new char[n+2][n+2];
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        String temp;
        for (int i = 1; i <= n; i++) {
            temp = sc.next();
            for (int j = 1; j <= n; j++){
                mat[i][j] = temp.charAt(j-1);
            }
        }

        int k = sc.nextInt();

        int r = 0;
        int c = 0;
        int dir = 1;

        //초기 위치, 방향 설정
        int tr, tc;
        for (int i = 0; i < k; i++){
            tr = r + dr[dir];
            tc = c + dc[dir];
            if (!inRange(tr, tc)){
                dir++;
                i--;
            }
            r += dr[dir];
            c += dc[dir];
        }
        dir = (dir + 1) % 4;

        // '/' 0 -> 1 1 -> 0 2 -> 3 3 -> 2
        // '\' 0 -> 3 3 -> 0 1 -> 2 2 -> 1
        int count = 0;
        while (true) {
            //System.out.print(r + " " + c +" -> ");
            r += dr[dir];
            c += dc[dir];
            //System.out.println(r + " " + c);

            if (mat[r][c] == '/') {
                dir = dir + (dir%2==0 ? 1 : -1);
            } else if (mat[r][c] == '\\') {
                dir = 3 - dir;
            } else {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c > 0 && c < n;
    }
}