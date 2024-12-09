import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Marble implements Comparable<Marble>{
    int r;
    int c;
    int dir;
    int v;
    int num;

    public Marble(int num, int r, int c, int dir, int v) {
        this.num = num;
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.v = v;
    }

    @Override
    public int compareTo(Marble marble) {
        if (this.v != marble.v) {
            return this.v - marble.v;
        } else {
            return this.num - marble.num;
        }
    }
}
public class Main {
    public static int n;
    public static int m;
    public static int t;
    public static int k;

    public static Marble[] marbles;
    public static ArrayList<Integer> removedMarbles;

    public static int[] dr = new int[]{-1, 0, 1, 0};
    public static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();

        marbles = new Marble[m];
        removedMarbles = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            marbles[i] = new Marble(i, sc.nextInt()-1, sc.nextInt()-1, dirMapper(sc.next().charAt(0)), sc.nextInt());
        }

        for (int i = 0; i < t; i++) {
            simulate();
        }

        System.out.println(m - removedMarbles.size());
    }

    public static int dirMapper(char dir) {
        if (dir == 'U') {
            return 0;
        } else if (dir == 'R') {
            return 1;
        } else if (dir == 'D') {
            return 2;
        }

        return 3;
    }

    public static void simulate() {
        ArrayList<Marble>[][] nextGrid = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextGrid[i][j] = new ArrayList<>();
            }
        }

        Arrays.sort(marbles);

        for (int i = 0; i < m; i++) {
            boolean isRemovedMarble = false; 
            for (int j = 0; j < removedMarbles.size(); j++) {
                if (removedMarbles.get(j) == marbles[i].num) {
                    isRemovedMarble = true; 
                    break;
                }
            }
            if(isRemovedMarble) continue;

            for (int j = 0; j < marbles[i].v; j++) {
                int nextR = marbles[i].r + dr[marbles[i].dir];
                int nextC = marbles[i].c + dc[marbles[i].dir];

                if (!inRange(nextR, nextC)) {
                    marbles[i].dir = (marbles[i].dir + 2) % 4;

                    nextR = marbles[i].r + dr[marbles[i].dir];
                    nextC = marbles[i].c + dc[marbles[i].dir];
                }

                marbles[i].r = nextR;
                marbles[i].c = nextC;
            }

            nextGrid[marbles[i].r][marbles[i].c].add(marbles[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(nextGrid[i][j].size() > k) {
                    for (int l = nextGrid[i][j].size() - 1; l >= k; l--) {
                        removedMarbles.add(nextGrid[i][j].get(l).num);
                    }
                }
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}