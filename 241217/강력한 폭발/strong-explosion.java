import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int n;
    public static int bombNumber;
    public static ArrayList<int[]> bombPositions;
    public static int[][] grid;

    public static int[] dr2 = new int[]{-1, 0, 1, 0};
    public static int[] dc2 = new int[]{0, 1, 0, -1};
    public static int[] dr3 = new int[]{-1, -1, 1, 1};
    public static int[] dc3 = new int[]{-1, 1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        bombPositions = new ArrayList<>();
        grid = new int[n][n];
        bombNumber = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int t = sc.nextInt();

                if (t == 1) {
                    bombPositions.add(new int[]{i, j});
                    grid[i][j] = 1;
                    bombNumber++;
                }
            }
        }

        System.out.println(simulate(0));
    }

    public static int simulate(int bombIndex) {
        if (bombIndex >= bombNumber) {
            return countExplosion();
        }
        int[] bombPos = bombPositions.get(bombIndex);
        int r = bombPos[0];
        int c = bombPos[1];

        int count = 0;
        //bomb #1
        for (int i = r - 2; i <= r+2; i++) {
            if (inRange(i, c)) {
                grid[i][c] += 1;
            }
        }
        count = Math.max(simulate(bombIndex + 1), count);
        for (int i = r - 2; i <= r+2; i++) {
            if (inRange(i, c)) {
                grid[i][c] -= 1;
            }
        }

        //bomb #2
        for (int i = 0; i < 4; i++) {
            if (inRange(r + dr2[i], c + dc2[i])) {
                grid[r + dr2[i]][c + dc2[i]] += 1;
            }
        }
        count = Math.max(simulate(bombIndex + 1), count);
        for (int i = 0; i < 4; i++) {
            if (inRange(r + dr2[i], c + dc2[i])) {
                grid[r + dr2[i]][c + dc2[i]] -= 1;
            }
        }

        //bomb #3
        for (int i = 0; i < 4; i++) {
            if (inRange(r + dr3[i], c + dc3[i])) {
                grid[r + dr3[i]][c + dc3[i]] += 1;
            }
        }
        count = Math.max(simulate(bombIndex + 1), count);
        for (int i = 0; i < 4; i++) {
            if (inRange(r + dr3[i], c + dc3[i])) {
                grid[r + dr3[i]][c + dc3[i]] -= 1;
            }
        }

        return count;
    }

    public static int countExplosion() {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) count++;
            }
        }

        return count;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}