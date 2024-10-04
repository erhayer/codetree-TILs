import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        String n = sc.next();
        int dec = binToDec(n, a);

        System.out.println(decToBin(dec, b));
    }
    public static String decToBin(int n, int b) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[20];
        int count = 0;

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
    public static int binToDec(String n, int b) {
        int num = 0;
        for (int i = 0; i < n.length(); i++) {
            num = num*b + n.charAt(i) - '0';
        }
        return num;
    }
}