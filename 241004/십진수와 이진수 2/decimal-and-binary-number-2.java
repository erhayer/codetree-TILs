import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int dec = binToDec(n);
        dec *= 17;
        System.out.println(decToBin(dec));
    }
    public static String decToBin(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[20];
        int count = 0;
        int b = 2;

        while(true) {
            if (n < b){
                arr[count] = n;
                break;
            }
            arr[count++] = n % b;
            n /= b;
        }

        for (int i = count; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static int binToDec(String n) {
        int num = 0;
        for (int i = 0; i < n.length(); i++) {
            num = num*2 + n.charAt(i) - '0';
        }
        return num;
    }
}