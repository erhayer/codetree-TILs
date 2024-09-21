import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println(power(a,b));
    }
    public static int power(int a, int b){
        int pow = 1;
        for (int i = 0; i < b; i++){
            pow *= a;
        }
        return pow;
    }
}