import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        foo(sc.nextInt());
    }
    public static void foo(int n){
        if (n == 0) return;
        System.out.print(n + " ");
        foo(n - 1);
        System.out.print(n + " ");
    }
}