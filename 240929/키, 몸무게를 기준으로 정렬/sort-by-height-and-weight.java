import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Man[] mans = new Man[n];

        for(int i = 0; i < n; i++){
            mans[i] = new Man(sc.next(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(mans);

        for(int i = 0; i < n; i++){
            mans[i].print();
        }
    }
}

class Man implements Comparable<Man> {
    String name;
    int h;
    int w;

    public Man(String name, int h, int w) {
        this.name = name;
        this.h = h;
        this. w = w;
    }

    @Override
    public int compareTo(Man man){
        if (this.h == man.h) {
            return man.w - this.w;
        }
        return this.h - man.h;
    }

    public void print() {
        System.out.println(this.name + " " + this.h + " " + this.w);
    }
}