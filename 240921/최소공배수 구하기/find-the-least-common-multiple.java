import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        lcm(sc.nextInt(), sc.nextInt());
    }
    public static int gcd(int n, int m){
        if (n % m == 0){
            return m;
        }
        return gcd(m, n%m);
    }
    public static void lcm(int n, int m){
        System.out.println(n * m / gcd(Math.max(n, m), Math.min(n, m)));
    }
}