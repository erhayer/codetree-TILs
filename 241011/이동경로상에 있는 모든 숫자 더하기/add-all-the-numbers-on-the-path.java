import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int t = sc.nextInt();
        String queries = sc.next();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        int r = n/2, c = n/2, dir = 0;

        char query;
        int tr, tc;
        int sum = mat[r][c];
        for (int i = 0; i < t; i++){
            query = queries.charAt(i);

            if (query == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else if (query == 'R') {
                dir = (dir + 1) % 4;
            } else {
                tr = r + dr[dir];
                tc = c + dc[dir];
                if (inRange(tr, tc)) {
                    r = tr;
                    c = tc;
                    sum += mat[r][c];
                }
            }
        }

        System.out.println(sum);
    }
    
    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}