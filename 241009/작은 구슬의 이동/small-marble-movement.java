import java.util.Scanner;

public class Main {
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int t = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        char d = sc.next().charAt(0);
        int dirNum = charToDir(d);

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, 1, -1, 0};

        int tr, tc;
        for (int i = 0; i < t; i++){
            tr = r + dr[dirNum];
            tc = c + dc[dirNum];
            if (inRange(tr, tc)) {
                r = tr;
                c = tc;
            } else {
                dirNum = 3 - dirNum;
            }
        }

        System.out.println((r + 1) + " " + (c + 1));
    }

    public static int charToDir(char d){
        if (d == 'U') return 0;
        if (d == 'R') return 1;
        if (d == 'L') return 2;
        return 3;
    }

    public static boolean inRange(int r, int c){
        return r>=0&&r<n&&c>=0&&c<n;
    }
}