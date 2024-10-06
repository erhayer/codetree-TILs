import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_NUM = 1000;
    public static int[] a = new int[MAX_NUM];
    public static int[] b = new int[MAX_NUM];
    public static int index_a = 0;
    public static int position_a = 0;
    public static int index_b = 0;
    public static int position_b = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            if (d == 'R') {
                for (int j = 0; j < t; j++){
                    index_a++;
                    position_a++;
                    a[index_a] = position_a;
                }
            } else {
                for (int j = 0; j < t; j++){
                    index_a++;
                    position_a--;
                    a[index_a] = position_a;
                }
            }
        }
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int t = Integer.parseInt(st.nextToken());

            if (d == 'R') {
                for (int j = 0; j < t; j++){
                    index_b++;
                    position_b++;
                    b[index_b] = position_b;
                }
            } else {
                for (int j = 0; j < t; j++){
                    index_b++;
                    position_b--;
                    b[index_b] = position_b;
                }
            }
        }

        int ans = -1;

        for (int i = 1; i < MAX_NUM; i++){
            if (a[i]-b[i] == 0) {
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}