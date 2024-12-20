import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[] tokens;
    public static int[] dists;
    public static int maxScore = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tokens = new int[k];
        for (int i = 0; i < k; i++) {
            tokens[i] = 1;
        }

        dists = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }

        findMaxScore(0);

        bw.write(Integer.toString(maxScore));
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }

    public static void findMaxScore(int index) {
        if (index >= n) {
            maxScore = Math.max(calc(), maxScore);
            return;
        }

        for (int i = 0; i < k; i++) {
            if (tokens[i] >= m) {
                continue;
            }

            tokens[i] += dists[index];
            findMaxScore(index + 1);
            tokens[i] -= dists[index];
        }
    }

    public static int calc() {
        int score = 0;

        for (int i = 0; i < k; i++) {
            if (tokens[i] >= m) {
                score++;
            }
        }

        return score;
    }
}