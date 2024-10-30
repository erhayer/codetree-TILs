import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        String str = sc.next();

        LinkedList<Character> breads = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            breads.add(str.charAt(i));
        }
        ListIterator<Character> pos = breads.listIterator(n);

        char inst;
        for (int i = 0; i < m; i++) {
            inst = sc.next().charAt(0);

            if (inst == 'L') {
                if (pos.hasPrevious()) {
                    pos.previous();
                }
            } else if (inst == 'R') {
                if (pos.hasNext()) {
                    pos.next();
                }
            } else if (inst == 'P') {
                pos.add(sc.next().charAt(0));
            } else {
                if (pos.hasNext()) {
                    pos.next();
                    pos.remove();
                }
            }
        }

        pos = breads.listIterator();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < breads.size(); i++) {
            sb.append(pos.next());
        }

        System.out.println(sb);
    }
}