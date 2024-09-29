import java.util.Scanner;

public class Main {
    public static int[] month_to_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        System.out.println((-dateTimeToMin(11, 11, 11, 11) + dateTimeToMin(11, a, b, c)) < 0 ? -1 : (-dateTimeToMin(11, 11, 11, 11) + dateTimeToMin(11, a, b, c)));
    }
    
    public static int dateTimeToMin(int mon, int date, int hour, int min) {
        int sum = 0;
        for (int i = 1; i < mon; i++){
            sum += month_to_days[i];
        }
        return (sum + date)*1440 + hour*60 + min;
    }
}