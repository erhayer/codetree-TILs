import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(fibonacci(sc.nextInt()));
    }
    public static int fibonacci(int n){
        if (n == 1 || n == 2) return 1;
        return fibonacci(n-2) + fibonacci(n-1);
    }
}