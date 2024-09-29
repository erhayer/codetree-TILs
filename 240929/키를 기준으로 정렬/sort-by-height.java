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
class Man implements Comparable<Man>{
    String name;
    int height;
    int weight;

    public Man(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Man man){
        return this.height - man.height;
    }

    public void print(){
        System.out.println(this.name + " " + this.height + " " + this.weight);
    }
}