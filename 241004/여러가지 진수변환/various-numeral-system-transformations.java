import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(notationChange(sc.nextInt(), sc.nextInt()));
    }
    public static String notationChange(int n, int b) {
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
}