import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();

        int n = sc.nextInt();
        int t = sc.nextInt();

        for (int i = 0; i < 2*n; i++) {
            deque.addLast(sc.nextInt());
        }

        for (int i = 0; i < t; i++) {
            int temp = deque.pollLast();
            deque.addFirst(temp);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }

        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}