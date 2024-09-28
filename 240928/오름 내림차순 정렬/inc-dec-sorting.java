import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());

        printArr(arr, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(arr2[i]).append(" ");
        }
        System.out.println(sb);
    }
    public static void printArr(int[] arr, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}