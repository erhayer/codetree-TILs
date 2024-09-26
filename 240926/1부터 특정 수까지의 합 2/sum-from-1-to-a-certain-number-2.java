import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(sum(sc.nextInt()));
    }
    public static int sum(int n){
        if (n == 1) return 1;
        return n + sum(n-1);
    }
}