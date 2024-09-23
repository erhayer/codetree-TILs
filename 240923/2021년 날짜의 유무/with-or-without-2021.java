import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int d = sc.nextInt();

        if (mdExists(m, d)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static boolean mdExists(int m, int d){
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            if (d <= 31 && d > 0) return true;
            return false;
        }
        if (m == 2){
            if (d <= 28 && d > 0) return true;
            return false;
        } else{
            if (d <= 30 && d > 0) return true;
            return false;
        }
    }
}