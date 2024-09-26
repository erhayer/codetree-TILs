import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(digitSum(sc.nextInt()*sc.nextInt()*sc.nextInt()));
    }
    public static int digitSum(int n){
        if (n < 10) return n;
        return n%10 + digitSum(n/10);
    }
}