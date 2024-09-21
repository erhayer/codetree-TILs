import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(stimin(sc.nextInt(), sc.nextInt(), sc.nextInt()));
    }
    public static int stimin(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}