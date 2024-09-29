import java.util.Scanner;

public class Main {
    public static int[] month_to_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();

        int day = dateToNum(c, d) - dateToNum(a, b) < 0 ? (dateToNum(c, d) - dateToNum(a, b))%7 + 7 : (dateToNum(c, d) - dateToNum(a, b)) % 7;
        String daystr;
        switch (day) {
            case 0:
                daystr = "Mon";
                break;
            case 1:
                daystr = "Tue";
                break;
            case 2:
                daystr = "Wed";
                break;
            case 3:
                daystr = "Thu";
                break;
            case 4:
                daystr = "Fri";
                break;
            case 5:
                daystr = "Sat";
                break;
            case 6:
                daystr = "Sun";
                break;
            default:
                daystr = "";
        }

        System.out.println(daystr);
    }
    public static int dateToNum(int m, int d) {
        int sum = 0;
        for (int i = 1; i < m; i++){
            sum += month_to_days[i];
        }
        return sum + d;
    }
}