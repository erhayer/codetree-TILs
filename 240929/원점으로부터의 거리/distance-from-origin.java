import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Dot[] dots = new Dot[n];
        for (int i = 0; i < n; i++){
            dots[i] = new Dot(i + 1, sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(dots);

        for (int i = 0; i < n; i++){
            System.out.println(dots[i].num);
        }
    }
}

class Dot implements Comparable<Dot> {
    int num;
    int x;
    int y;

    public Dot(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Dot dot) {
        if ((Math.abs(this.x) + Math.abs(this.y)) == (Math.abs(dot.x) + Math.abs(dot.y))){
            return this.num - dot.num;
        }
        return (Math.abs(this.x) + Math.abs(this.y)) - (Math.abs(dot.x) + Math.abs(dot.y));
    }
}