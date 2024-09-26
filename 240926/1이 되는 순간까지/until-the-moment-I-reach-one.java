import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, n = sc.nextInt();
        System.out.println(foo(n, count));
    }
    public static int foo(int n, int count){
        if (n == 1) return count;
        if (n%2 == 0){
            return foo(n/2, ++count);
        } else{
            return foo(n/3, ++count);
        }
    }
}