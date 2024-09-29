import java.util.Scanner;
import java.util.Arrays;

class Man {
    String name;
    int height;
    float weight;

    public Man(String name, int height, float weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }
    public void print() {
        System.out.println(this.name + " " + this.height + " " + this.weight);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;

        Man[] mans = new Man[n];
        for (int i = 0; i < n; i++){
            mans[i] = new Man(sc.next(), sc.nextInt(), sc.nextFloat());
        }

        Arrays.sort(mans, (a, b) -> a.name.compareTo(b.name));

        System.out.println("name");
        for (int i = 0; i < n; i++){
            mans[i].print();
        }

        Arrays.sort(mans, (a, b) -> b.height - a.height);

        System.out.println("\nheight");
        for (int i = 0; i < n; i++){
            mans[i].print();
        }
    }
}