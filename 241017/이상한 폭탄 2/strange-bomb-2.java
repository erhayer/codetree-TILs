import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }

        int max_bomb = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0 && bombs[i-j] == bombs[i]) {
                    max_bomb = Math.max(bombs[i], max_bomb);
                    break;
                }
                if (i+j < k && bombs[i+j] == bombs[i]) {
                    max_bomb = Math.max(bombs[i], max_bomb);
                    break;
                }
            }
        }

        System.out.println(max_bomb);
    }
}