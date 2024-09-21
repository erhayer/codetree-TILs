import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int count = 0;
        for (int i = a; i <= b; i++){
            if (isMagicNumber(i)) count++;
        }
        System.out.println(count);
    }
    public static boolean isMagicNumber(int n){
        return n % 3 == 0 || containsThirds(n);
    }
    public static boolean containsThirds(int n){
        boolean temp = false;
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9'){
                temp = true;
            }
        }
        return temp;
    }
}