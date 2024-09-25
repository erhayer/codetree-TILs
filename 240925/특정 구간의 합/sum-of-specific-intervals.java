import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    public static final int MAX_N = 100;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++){
            printSum(sc.nextInt(), sc.nextInt());
        }
    }
    public static void printSum(int a1, int a2){
        int sum = 0;
        for (int i = a1 - 1; i < a2; i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}