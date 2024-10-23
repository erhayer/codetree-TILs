import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int minDis = Integer.MAX_VALUE;
        
        minDis = Math.min(Math.abs(b-a), minDis);
        minDis = Math.min(Math.abs(x-a)+Math.abs(b-y), minDis);
        minDis = Math.min(Math.abs(y-a)+Math.abs(b-x), minDis);

        System.out.println(minDis);
    }
}