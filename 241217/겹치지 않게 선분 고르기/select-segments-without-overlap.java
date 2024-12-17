import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] lines;
    
    public static final int MAX = 1000;
    public static int[] grid = new int[MAX+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            lines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        System.out.println(countNotOverlappingLines(0, 0));
    }

    public static int countNotOverlappingLines(int index, int count) {
        if (index >= n) {
            return count;
        }

        int cnt = count;

        boolean isOverlapping = false;
        for (int i = lines[index][0]; i <= lines[index][1]; i++) {
            if (grid[i] > 0) {
                isOverlapping = true;
                break;
            }
        }
        
        if (!isOverlapping) {
            for (int i = lines[index][0]; i <= lines[index][1]; i++) {
                grid[i] = 1;
            }

            cnt = countNotOverlappingLines(index + 1, count+1);

            for (int i = lines[index][0]; i <= lines[index][1]; i++) {
                grid[i] = 0;
            }
        }

        cnt = Math.max(countNotOverlappingLines(index + 1, count), cnt);

        return cnt;
    }
}