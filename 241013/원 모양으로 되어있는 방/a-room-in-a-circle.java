import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //입력 받음
        int n = sc.nextInt();
        int[] caps = new int[n];
        for (int i = 0; i < n; i++){
            caps[i] = sc.nextInt();
        }

        //brute force
        int temp;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            temp = 0;
            for (int j = 0; j < n; j++){
                temp += caps[j]*((j - i + n) % n);
            }
            min = Math.min(temp, min);
        }

        System.out.println(min);
    }
}