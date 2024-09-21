import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();
        if (isLeapYear(y)){
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }
    public static boolean isLeapYear(int y){
        if (y%100==0 && y%400!=0) return false;
        if (y%4==0) return true;
        return false;
    }
}