import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println(foo(sc.nextInt()));
    }
    public static int foo(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum+=i;
        }
        return sum/10;
    }
}