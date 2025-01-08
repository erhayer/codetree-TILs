import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] graph;
    public static boolean[] visited;
    public static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }



        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        DFS(1);

        System.out.println(cnt);
    }

    public static void DFS(int nord) {
        for (int i = 2; i <= n; i++) {
            if (graph[nord][i] == 1 && !visited[i]) {
                visited[i] = true;
                cnt++;
                DFS(i);
            }
        }
    }
}