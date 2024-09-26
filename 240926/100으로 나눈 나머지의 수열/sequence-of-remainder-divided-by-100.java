import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(foo(sc.nextInt()));
    }
    public static int foo(int n){
        if (n== 1){
            return 2;
        }
        if (n == 2) return 4;
        return foo(n-1)*foo(n-2)%100;
    }
}