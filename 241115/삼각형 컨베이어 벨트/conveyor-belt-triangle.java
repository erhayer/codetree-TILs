import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        Deque<Integer>[] conveyors = new Deque[3];

        for (int i = 0; i < 3; i++) {
            conveyors[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                conveyors[i].addLast(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < t; i++) {
            conveyors[0].addFirst(conveyors[2].pollLast());
            conveyors[1].addFirst(conveyors[0].pollLast());
            conveyors[2].addFirst(conveyors[1].pollLast());
        }

        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(conveyors[i].pollFirst()).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}