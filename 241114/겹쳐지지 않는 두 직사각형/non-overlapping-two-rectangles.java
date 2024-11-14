import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[][] mat;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        //first rectangular
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = c1; c2 < m; c2++) {

                        //second rectagular
                        for (int a1 = 0; a1 < n; a1++) {
                            for (int b1 = 0; b1 < m; b1++) {
                                for (int a2 = a1; a2 < n; a2++) {
                                    for (int b2 = b1; b2 < m; b2++) {
                                        if (isOverlapping(r1, c1, r2, c2, a1, b1, a2, b2)) {
                                            continue;
                                        }

                                        max = Math.max(calRectangular(r1, c1, r2, c2) + calRectangular(a1, b1, a2, b2), max);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static boolean isOverlapping(int r1, int c1, int r2, int c2, int a1, int b1, int a2, int b2) {
        return !(a1 > r2 || r1 > a2 || b1 > c2 || c1 > b2);
    }

    public static int calRectangular(int r1, int c1, int r2, int c2) {
        int sum = 0;
        
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += mat[i][j];
            }
        }

        return sum;
    }
}