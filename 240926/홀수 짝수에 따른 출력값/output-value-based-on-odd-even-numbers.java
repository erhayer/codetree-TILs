import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(foo(sc.nextInt()));
    }
    public static int foo(int n){
        if (n <= 2) return n;
        return n + foo(n-2);
    }
}