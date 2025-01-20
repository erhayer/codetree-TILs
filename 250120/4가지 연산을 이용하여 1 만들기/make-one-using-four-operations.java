import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static final int MAX_N = 1000000;

    public static int[] dp = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N+1];

    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        bfs();

        System.out.println(dp[sc.nextInt()]);
    }

    public static void bfs() {
        for (int i = 0; i <= MAX_N; i++) {
            visited[i] = false;
        }
        visited[0] = true;

        dp[1] = 0;
        visited[1] = true;
        q.add(1);

        while(!q.isEmpty()) {
            int num = q.poll();

            if(canGo(num - 1)) {
                dp[num - 1] = dp[num] + 1;
                visited[num - 1] = true;
                q.add(num - 1);
            }
            if(canGo(num + 1)) {
                dp[num + 1] = dp[num] + 1;
                visited[num + 1] = true;
                q.add(num + 1);
            }
            if(canGo(num * 2)) {
                dp[num * 2] = dp[num] + 1;
                visited[num * 2] = true;
                q.add(num * 2);
            }
            if(canGo(num * 3)) {
                dp[num * 3] = dp[num] + 1;
                visited[num * 3] = true;
                q.add(num * 3);
            }
        }
    }

    public static boolean canGo(int i) {
        return i > 0 && i <= MAX_N && !visited[i];
    }
}