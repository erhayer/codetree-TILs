import java.util.Scanner;

class intWrapper {
    int value;
    intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        intWrapper a = new intWrapper(n);
        intWrapper b = new intWrapper(m);

        swap(a, b);

        System.out.println(a.value + " " + b.value);
    }
    public static void swap(intWrapper a, intWrapper b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}