import java.util.Scanner;

public class Main {
    public static int[] month_to_days = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String day = sc.next();

        int d_to_d = monthDateToInt(m2, d2) - monthDateToInt(m1, d1);
        int result = 0;

        if (d_to_d == 0){
            result = 0;
        } else if (day.compareTo("Mon") == 0){
            result = d_to_d / 7 + 1;
        } else if ((day.compareTo("Tue") == 0)){
            result = (d_to_d - 1) / 7 + 1;
        } else if ((day.compareTo("Wed") == 0)){
            result = (d_to_d - 2) / 7 + 1;
        } else if ((day.compareTo("Thu") == 0)){
            result = (d_to_d - 3) / 7 + 1;
        } else if ((day.compareTo("Fri") == 0)){
            result = (d_to_d - 4) / 7 + 1;
        } else if ((day.compareTo("Sat") == 0)){
            result = (d_to_d - 5) / 7 + 1;
        } else if ((day.compareTo("Sun") == 0)){
            result = (d_to_d - 6) / 7 + 1;
        }

        System.out.println(result);
    }

    public static int monthDateToInt(int m, int d) {
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += month_to_days[i];
        }
        return sum + d;
    }
}