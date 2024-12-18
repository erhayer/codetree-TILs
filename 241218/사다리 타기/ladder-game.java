import java.util.Scanner;

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static final int MAX_DEPTH = 15;
    public static int n;
    public static int m;
    public static Pair[] lines;
    public static int[][] ladders;
    public static int[] originalResult;

    public static int minLinesCount;
    public static int currentLinesCount;
    public static int[] tempResult;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        lines = new Pair[m];
        ladders = new int[MAX_DEPTH + 1][n + 1];
        minLinesCount = m;
        currentLinesCount = m;

        for (int i = 1; i <= MAX_DEPTH; i++) {
            for (int j = 1; j <= n; j++) {
                ladders[i][j] = j;
            }
        }

        for (int i = 0; i < m; i++) {
            lines[i] = new Pair(sc.nextInt(), sc.nextInt());

            ladders[lines[i].b][lines[i].a] = lines[i].a + 1;
            ladders[lines[i].b][lines[i].a + 1] = lines[i].a;
        }

        originalResult = getGhostLaddersResult();

        calMinimumLinesCount(0);

        System.out.println(minLinesCount);
    }

    public static int[] getGhostLaddersResult() {
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int currentColumn = i;
            
            for (int j = 1; j <= MAX_DEPTH; j++) {
                currentColumn = ladders[j][currentColumn];
            }

            result[i] = currentColumn;
        }

        return result;
    }


    public static void calMinimumLinesCount(int line) {
        if (line >= m) {
            tempResult = getGhostLaddersResult();

            boolean isSame = true;
            for (int i = 0; i < n; i++) {
                if (tempResult[i] != originalResult[i]) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                minLinesCount = Math.min(currentLinesCount, minLinesCount);
            }

            return;
        }

        ladders[lines[line].b][lines[line].a] = lines[line].a;
        ladders[lines[line].b][lines[line].a + 1] = lines[line].a + 1;

        currentLinesCount--;
        calMinimumLinesCount(line + 1);

        ladders[lines[line].b][lines[line].a] = lines[line].a + 1;
        ladders[lines[line].b][lines[line].a + 1] = lines[line].a;

        currentLinesCount++;
        calMinimumLinesCount(line + 1);
    }
}