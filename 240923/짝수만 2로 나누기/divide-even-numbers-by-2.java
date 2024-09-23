import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        divBy2(arr, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
    public static void divBy2(int[] arr, int n){
        for (int i = 0; i < n; i++){
            if (arr[i]%2==0) arr[i] /= 2;
        }
    }
}