import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 6;
        int[] devs = new int[6];
        int sum = 0;
        int t;
        for (int i = 0; i < 6; i++){
            t = sc.nextInt();
            devs[i] = t;
            sum += t;
        }

        int min = Integer.MAX_VALUE;
        int sub;
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n-1; j++){
                for (int k = j+1; k < n; k++){
                    sub = sum -2*(devs[i] + devs[j] + devs[k]);
                    min = Math.min(Math.abs(sub), min);
                }
            }
        }

        System.out.println(min);
    }
}