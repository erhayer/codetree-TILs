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
        int[] init = new int[]{0, n+1, n+1, 0};

        int f = (k-1)/n;
        if (f == 0) {
            r = init[f];
            c = (k-1)%n + 1;
            dir = 2;
        } else if (f == 1) {
            r = (k-1)%n + 1;
            c = init[f];
            dir = 3;
        } else if (f == 2) {
            r = init[f];
            c = n -(k-1)%n;
            dir = 0;
        } else {
            r = n -(k-1)%n;
            c = init[f];
            dir = 1;
        }

        // '/' 0 -> 1 1 -> 0 2 -> 3 3 -> 2
        // '\' 0 -> 3 3 -> 0 1 -> 2 2 -> 1
        int count = 0;
        while (true) {
            r += dr[dir];
            c += dc[dir];

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
        return r >= 0 && r < n+2 && c > 0 && c < n+2;
    }
}