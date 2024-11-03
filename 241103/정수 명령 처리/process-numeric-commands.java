import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();

        String query;
        int a;
        for (int i = 0; i < n; i++) {
            query = sc.next();

            if (query.equals("push")) {
                a = sc.nextInt();

                stack.push(a);
            } else if (query.equals("pop")) {
                System.out.println(stack.pop());
            } else if (query.equals("size")) {
                System.out.println(stack.size());
            } else if (query.equals("empty")) {
                System.out.println(stack.empty() ? 1 : 0);
            } else if (query.equals("top")) {
                System.out.println(stack.peek());
            }
        }
    }
}