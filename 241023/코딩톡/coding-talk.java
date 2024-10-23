import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        int[] users = new int['Z' + 1];

        int[][] messages = new int[m][2];
        for (int i = 0; i < n; i++) {
            char user = sc.next().charAt(0);
            int unread = sc.nextInt();

            messages[i] = new int[]{user, unread};
        }

        for (int i = p-1; i < n; i++) {
            users[messages[i][0]]++;
        }

        for (int i = 'A'; i < 'A' + n; i++) {
            if (users[i] > 0) continue;
            System.out.print((char)i + " ");
        }
    }
}