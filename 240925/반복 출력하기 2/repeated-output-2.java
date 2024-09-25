import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        hello(sc.nextInt());
    }
    public static void hello(int n){
        if (n == 0)
            return;
        hello(n-1);
        System.out.println("HelloWorld");
    }
}