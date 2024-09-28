import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            if(i%2==0){
                System.out.print(mid(arr, i+1) + " ");
            }
        }
    }
    public static int mid(int[] arr, int end){
        Arrays.sort(arr, 0, end);
        return arr[end/2];
    }
}