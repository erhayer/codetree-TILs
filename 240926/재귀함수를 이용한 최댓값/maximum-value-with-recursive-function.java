import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(max(arr, 0, Integer.MIN_VALUE));
    }
    public static int max(int[] arr, int index, int m){
        if (index == arr.length) return m;
        if (arr[index] > m) return max(arr, ++index, arr[index]);
        return max(arr, ++index, m);
    }
}