import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 0;
        int b = 0;

        int tempA = 0;
        int tempB = 0;
        int score;
        char user;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            user = sc.next().charAt(0);
            score = sc.nextInt();

            if (user == 'A') {
                tempA += score;
            } else {
                tempB += score;
            }
            
            if (a == b) {
                if (tempA != tempB) {
                    cnt++;
                    //System.out.println(i + "1!");
                }
            } else {
                if ((a-b)*(tempA-tempB) <= 0) {
                    cnt++;
                    //System.out.println(i + "2!");
                }
            }

            a = tempA;
            b = tempB;
        }

        System.out.println(cnt);
    }
}