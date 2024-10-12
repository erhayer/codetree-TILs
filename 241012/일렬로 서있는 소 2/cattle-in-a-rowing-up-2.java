import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cows = new int[n];
        for (int i = 0; i < n; i++){
            cows[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                for (int k = j+1; k < n; k++){
                    if (cows[i] <= cows[j] && cows[j] <= cows[k]) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}