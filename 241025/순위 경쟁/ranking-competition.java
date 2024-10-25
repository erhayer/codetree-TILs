import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = 0;
        int b = 0;
        int c = 0;

        int tempA = 0;
        int tempB = 0;
        int tempC = 0;
        int score;
        char user;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            user = sc.next().charAt(0);
            score = sc.nextInt();

            if (user == 'A') {
                tempA += score;
            } else if (user == 'B') {
                tempB += score;
            } else {
                tempC += score;
            }
            
            if (status(a, b, c) != status(tempA, tempB, tempC)) {
                cnt++;
            }

            a = tempA;
            b = tempB;
            c = tempC;
        }

        System.out.println(cnt);
    }

    public static int status(int a, int b, int c) {
        if (a == b && b == c) {
            return 0;
        } else if (a > b && a > c) {
            return 1;
        } else if (b > a && b > c) {
            return 2;
        } else if (c > a && c > b) {
            return 3;
        } else if (a == b) {
            return 4;
        } else if (b == c) {
            return 5;
        } else {
            return 6;
        }
    }
}