import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> dq = new ArrayDeque<>();

        int n = sc.nextInt();

        String query;
        int a;
        for (int i = 0; i < n; i++) {
            query = sc.next();

            if (query.equals("push_front")) {
                a = sc.nextInt();

                dq.addFirst(a);
            } else if (query.equals("push_back")) {
                a = sc.nextInt();

                dq.addLast(a);
            } else if (query.equals("pop_front")) {
                System.out.println(dq.pollFirst());
            } else if (query.equals("pop_back")) {
                System.out.println(dq.pollLast());
            } else if (query.equals("size")) {
                System.out.println(dq.size());
            } else if (query.equals("empty")) {
                System.out.println(dq.isEmpty() ? 1 : 0);
            } else if (query.equals("front")) {
                System.out.println(dq.peekFirst());
            } else if (query.equals("back")) {
                System.out.println(dq.peekLast());
            }
        }
    }
}