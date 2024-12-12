import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Marble implements Comparable<Marble> {
    int weight;
    int num;
    int dir;
    int r;
    int c;

    public Marble(int r, int c, int weight, int dir, int num) {
        this.weight = weight;
        this.num = num;
        this.dir = dir;
        this.r = r;
        this.c = c;
    }
    
    @Override
    public int compareTo(Marble m) {
        if (this.weight != m.weight) {
            return m.weight - this.weight;
        } else {
            return m.num - this.num;
        }
    }
}


public class Main {
    public static final int MAX = 2000;
    public static int[] dr = new int[]{0, 1, 0, -1};
    public static int[] dc = new int[]{1, 0, -1, 0};

    public static int[][] grid = new int[2*MAX+1][2*MAX+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            Marble[] marbles = new Marble[n];

            for (int j = 0; j < n; j++) {
                marbles[j] = new Marble(sc.nextInt() * 2, sc.nextInt() * 2, sc.nextInt(), DirMapper(sc.next().charAt(0)), j);
            }

            sb.append(simulate(n, marbles)).append("\n");
        }

        System.out.println(sb);
    }

    public static int DirMapper(char dirChar) {
        if (dirChar == 'U') {
            return 0;
        } else if (dirChar == 'R') {
            return 1;
        } else if (dirChar == 'D') {
            return 2;
        } else {
            return 3;
        }
    }

    public static int simulate(int n, Marble[] marbles) {
        Arrays.sort(marbles);

        int numOfRemovedMarbles = 0;
        int numOfEscapedMarbles = 0;
        boolean[] isExcepted = new boolean[n];

        for (int i = 0; i < n; i++) {
            isExcepted[i] = false;
        }

        int t = 0;
        int lastCollisionTime = -1;
        while (numOfEscapedMarbles + numOfRemovedMarbles < n) {
            t++;

            for (int i = 0; i < n; i++) {
                //System.out.println(marbles[i].r + " " + marbles[i].c + " " + marbles[i].num + " " + marbles[i].dir*10 + " " + marbles[i].weight);
                if (isExcepted[i]) continue;

                marbles[i].r += dr[marbles[i].dir];
                marbles[i].c += dc[marbles[i].dir];

                if (inRange(marbles[i].r, marbles[i].c)) {
                    if (grid[marbles[i].r + 2000][marbles[i].c + 2000] != 1) {
                        grid[marbles[i].r + 2000][marbles[i].c + 2000] = 1;
                    } else {
                        isExcepted[i] = true;
                        numOfRemovedMarbles++;
                        lastCollisionTime = t;
                    }
                } else {
                    isExcepted[i] = true;
                    numOfEscapedMarbles++;
                }
            }

            //System.out.println();

            for (int i = 0; i < n; i++) {
                if (isExcepted[i]) continue;
                grid[marbles[i].r + 2000][marbles[i].c + 2000] = 0;
            }
        }

        return lastCollisionTime;
    }

    public static boolean inRange(int r, int c) {
        return r >= -MAX && r <+ MAX && c >= -MAX && c <= MAX;
    }

    public static void clearGrid() {
        for (int i = 0; i <= MAX*2; i++) {
            for (int j = 0; j < MAX*2; j++) {
                grid[i][j] = 0;
            }
        }
    }
}