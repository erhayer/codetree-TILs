import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        int count = 0;
        int count_result = -1;
        for (int i = 0; i < a.length() - 1; i++){
            if (a.compareTo(b) == 0){
                count_result = count;
                break;
            }
            count++;
            a = shift(a);
        }

        System.out.println(count_result);
    }

    public static String shift(String str){
        return str.charAt(str.length()-1) + str.substring(0, str.length()-1);
    }
}