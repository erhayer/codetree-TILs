import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static int n;
    public static boolean[][] canGo;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        canGo = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                canGo[i][j] = true;

                if (sc.nextInt() == 0) {
                    canGo[i][j] = false;
                }
            }
        }

        int cntOfTown = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (canGo[i][j]) {
                    cntOfTown++;
                    
                    cnt = 0;
                    DFS(i, j);

                    arr.add(cnt);
                }
            }
        }

        System.out.println(cntOfTown);
        
        Collections.sort(arr);

        for (int i = 0; i < cntOfTown; i++) {
            System.out.println(arr.get(i));
        }
    }

    public static void DFS(int r, int c) {
        cnt++;
        canGo[r][c] = false;

        if (inRange(r + 1, c) && canGo[r+1][c]) {
            DFS(r + 1, c);
        }
        if (inRange(r, c + 1) && canGo[r][c+1]) {
            DFS(r, c + 1);
        }
        if (inRange(r - 1, c) && canGo[r-1][c]) {
            DFS(r - 1, c);
        }
        if (inRange(r, c - 1) && canGo[r][c-1]) {
            DFS(r, c - 1);
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}