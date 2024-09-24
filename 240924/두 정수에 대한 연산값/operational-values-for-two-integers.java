import java.util.Scanner;

class IntWrapper {
    int n;
    public IntWrapper(int n){
        this.n = n;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IntWrapper a = new IntWrapper(sc.nextInt());
        IntWrapper b = new IntWrapper(sc.nextInt());

        swap(a, b);

        System.out.println(a.n + " " + b.n);
    }
    public static void swap(IntWrapper iw1, IntWrapper iw2){
        if (iw1.n >= iw2.n){
            iw1.n += 25;
            iw2.n *= 2;
        } else{
            iw2.n += 25;
            iw1.n *= 2;
        }
    }
}