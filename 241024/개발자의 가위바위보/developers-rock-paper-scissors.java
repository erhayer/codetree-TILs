import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int a, b;
        int[][] games = new int[n][2];
        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            
            games[i] = new int[]{a, b};
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < n; i++){
            if (games[i][0] == games[i][1]) continue;
            if ((games[i][0] == 1 && games[i][1] == 2) || (games[i][0] == 2 && games[i][1] == 3) || (games[i][0] == 3 && games[i][1] == 1)) {
                cnt1++;
            } else {
                cnt2++;
            }
        }

        System.out.println(Math.max(cnt1, cnt2));
    }
}