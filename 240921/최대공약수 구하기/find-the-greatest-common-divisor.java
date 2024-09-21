import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        prime(n, m);
    }
    public static void prime(int n, int m){
        int temp = 1;
        
        for (int i = 2; i <= Math.max(n, m); i++){
            if(n%i==0&&m%i==0) temp = i;
        }

        System.out.println(temp);
    }
}