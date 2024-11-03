import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<Integer> queue = new LinkedList<>();

        int n = sc.nextInt();

        String query;
        int a;
        for (int i = 0; i < n; i++) {
            query = sc.next();

            if (query.equals("push")) {
                a = sc.nextInt();

                queue.add(a);
            } else if (query.equals("pop")) {
                System.out.println(queue.poll());
            } else if (query.equals("size")) {
                System.out.println(queue.size());
            } else if (query.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (query.equals("front")) {
                System.out.println(queue.peek());
            }
        }
    }
}