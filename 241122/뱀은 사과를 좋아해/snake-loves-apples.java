import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int n;
    public static int m;
    public static int k;

    public static int tailR = 0;
    public static int tailC = 0;
    public static int tailDir = 0;

    public static int headR = 0;
    public static int headC = 0;
    public static int time = 0;

    public static char[][] mat;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        mat = new char[n][n];
        mat[0][0] = 'h';

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;

            mat[r][c] = 'a';
        }

        //print();

        Queue<int[]> tails = new LinkedList<>();


        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int dir = 0;
        boolean ended = false;
        for (int i = 0; i < k; i++) {
            int d = sc.next().charAt(0);
            int p = sc.nextInt();

            if (d == 'U') {
                dir = 0;
            } else if (d == 'D') {
                dir = 2;
            } else if (d == 'R') {
                dir = 1;
            } else {
                dir = 3;
            }

            for (int j = 0; j < p; j++) {
                time++;

                int nextR = headR + dr[dir];
                int nextC = headC + dc[dir];

                if (!inRange(nextR, nextC)) {
                    ended = true;
                    break;
                }

                mat[headR][headC] = 't';
                tails.add(new int[]{headR, headC, dir});

                if (!(mat[nextR][nextC] == 'a') && !tails.isEmpty()) {
                    mat[tails.peek()[0]][tails.peek()[1]] = ' ';
                    tailR += dr[tails.peek()[2]];
                    tailC += dc[tails.peek()[2]];

                    tails.poll();
                }

                if (mat[nextR][nextC] == 't') {
                    ended = true;
                    break;
                }

                mat[nextR][nextC] = 'h';
                
                headR = nextR;
                headC = nextC;
            }

            //print();

            if (ended) {
                break;
            }
        }

        System.out.println(time);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(mat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}