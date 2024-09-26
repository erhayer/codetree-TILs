import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(foo(sc.nextInt()));
    }
    public static int foo(int n){
        if (n == 1) return 0;
        return foo(n%2==0 ? n/2 : n*3+1) + 1;
    }
}