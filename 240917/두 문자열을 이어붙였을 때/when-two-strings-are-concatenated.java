import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        String sum1 = str1 + str2;
        String sum2 = str2 + str1;
        if (sum1.compareTo(sum2) == 0){
            System.out.println("true");
        } else{
            System.out.println("false");
        }
    }
}