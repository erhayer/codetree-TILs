import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[][] grid = new LinkedList[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = new LinkedList<>();
                grid[i][j].add(Integer.parseInt(st.nextToken()));
            }
        }

        int[] dr = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dc = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isMoved = false;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (grid[j][k].size() > 0) {
                        int numIndex = -1 ;
                        for (int l = 0; l < grid[j][k].size(); l++) {
                            if (grid[j][k].get(l) == num) {
                                numIndex = l;
                                break;
                            }
                        }
                        if (numIndex != -1) {

                            isMoved = true;

                            int max = 0;
                            int maxR = j - 1;
                            int maxC = k;

                            for (int dir = 0; dir < 8; dir++) {
                                int nextR = j + dr[dir];
                                int nextC = k + dc[dir];

                                if (inRange(nextR, nextC, n) && grid[nextR][nextC].size() > 0) {
                                    for (int l = 0; l < grid[nextR][nextC].size(); l++) {
                                        if (grid[nextR][nextC].get(l) > max) {
                                            max = grid[nextR][nextC].get(l);
                                            maxR = nextR;
                                            maxC = nextC;
                                        }
                                    }      
                                }
                            }

                            if (max != 0) {
                                int tempSize = grid[j][k].size();
                                for (int l = numIndex; l < tempSize; l++) {
                                    grid[maxR][maxC].add(grid[j][k].get(l));
                                }

                                for (int l = numIndex; l < tempSize; l++) {
                                    grid[j][k].pollLast();
                                }
                            }

                            break;
                        }
                    } 
                    
                }

                if (isMoved) break;
            }
        }

        printGrid(grid, n);
    }

    public static boolean inRange(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void printGrid(LinkedList[][] grid, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].size() > 0) {
                    for (int k = grid[i][j].size() - 1; k >= 0; k--) {
                        sb.append(grid[i][j].get(k)).append(" ");
                    }
                } else {
                    sb.append("None");
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}