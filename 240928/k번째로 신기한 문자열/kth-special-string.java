import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String t = sc.next();

        String[] arr = new String[n];
        int cnt = 0, idx = 0;
        String temp = "";
        while(idx < n){
            temp = sc.next();
            if (t.length() >= temp.length && temp.substring(0, t.length()).compareTo(t) == 0){
                arr[cnt++] = temp;
            }
            idx++;
        }
        Arrays.sort(arr, 0, cnt);

        System.out.println(arr[k-1]);
    }
}