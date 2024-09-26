import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(foo(sc.nextInt()));
    }
    public static int foo(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        return foo(n/3) + foo(n-1);
    }
}