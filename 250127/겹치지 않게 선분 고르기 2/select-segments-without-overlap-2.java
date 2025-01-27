import java.util.Scanner;
import java.util.Arrays;

class Line implements Comparable<Line>{
    int x1;
    int x2;

    public Line(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Line o) {
        return this.x2 - o.x2;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lines);

        int cnt = 0;
        int lastX2 = -1;
        for (int i = 0; i < n; i++) {
            if (lines[i].x1 > lastX2) {
                cnt++;
                lastX2 = lines[i].x2;
            }
        }

        System.out.println(cnt);
    }
}