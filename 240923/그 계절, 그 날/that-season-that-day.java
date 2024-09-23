import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        if (mdExists(y, m, d)){
            System.out.println(weather(m));
        } else{
            System.out.println(-1);
        }
    }
    public static boolean isLeapYear(int y){
        if (y%400==0) return true;
        if (y%100==0) return false;
        if (y%4==0) return true;
        return false;
    }
    public static boolean mdExists(int y, int m, int d){
        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            if (d <= 31 && d > 0) return true;
        }
        if (m == 4 || m == 6 || m == 9 || m == 11){
            if (d <= 30 && d > 0) return true;
        }
        if (m == 2){
            if (d <= (isLeapYear(y) ? 29 : 28) && d > 0) return true;
        }
        return false;
    }
    public static String weather(int m){
        if (m >= 3 && m <=5){
            return "Spring";
        }
        if (m >= 6 && m <= 8){
            return "Summer";
        }
        if (m >= 9 && m <= 11){
            return "Fall";
        }
        if (m == 12 || m == 1 || m == 2){
            return "Winter";
        }
        return "-1";
    }
}