import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        int[] users = new int['Z' + 1];

        int[][] messages = new int[m][2];
        for (int i = 0; i < m; i++) {
            char user = sc.next().charAt(0);
            int unread = sc.nextInt();

            messages[i] = new int[]{user, unread};
        }
        
        if (messages[p-1][1] == 0) {
            System.out.println();
        } else {
            for (int i = p-1; i < m; i++) {
                users[messages[i][0]]++;
            }
            for (int i = p-2; i >= 0; i--) {
                if (messages[i][1] != messages[i+1][1]) break;
                users[messages[i][0]]++;
            }

            for (int i = 'A'; i < 'A' + n; i++) {
                if (users[i] > 0) continue;
                System.out.print((char)i + " ");
            }
        }
    }
}