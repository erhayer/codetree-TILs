import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k-1; j++) {
                q.add(q.peek());
                q.poll();
            }

            sb.append(q.poll()).append(" ");
        }

        System.out.println(sb);
    }
}