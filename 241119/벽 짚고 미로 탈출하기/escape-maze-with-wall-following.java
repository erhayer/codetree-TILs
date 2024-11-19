import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int initR = Integer.parseInt(st.nextToken())-1;
        int initC = Integer.parseInt(st.nextToken())-1;

        char[][] mat = new char[n][n];

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                mat[i][j] = str.charAt(j);
            }
        }

        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int r = initR;
        int c = initC;
        int dir = 1;
        int time = 0;

        boolean escaped = false;
        while(!escaped) {
            if (mat[r + dr[(dir + 1) % 4]][c + dc[(dir+1)%4]] == '#') {
                if (inRange(r+dr[dir], c+dc[dir])) {
                    if (mat[r+dr[dir]][c+dc[dir]] == '#') {
                        dir = (dir - 1 + 4) % 4;
                    } else {
                        r += dr[dir];
                        c += dc[dir];
                        time++;
                    }
                } else {
                    r += dr[dir];
                    c += dc[dir];
                    time++;
                    escaped = true;
                }
            } else {
                dir = (dir + 1) % 4;
                r += dr[dir];
                c += dc[dir];
                time++;
            }

            if (r == initR && c == initC && dir == 1) {
                time = -1;
                break;
            }

            //System.out.println(r + " " + c + " " + dir);
        }

        System.out.println(time);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}