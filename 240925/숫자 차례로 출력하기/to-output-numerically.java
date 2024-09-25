import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ascd(n);
        System.out.println();
        desc(n);
    }
    public static void ascd(int n){
        if (n == 0) return;
        ascd(n-1);
        System.out.print(n + " ");
    }
    public static void desc(int n){
        if (n == 0) return;
        System.out.print(n + " ");
        desc(n-1);
    }
}