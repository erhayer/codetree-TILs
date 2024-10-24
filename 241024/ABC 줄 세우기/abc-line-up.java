import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] alphabets = new char[n];

        for (int i = 0; i < n; i++) {
            alphabets[i] = sc.next().charAt(0);
        }

        char temp;
        int cnt = 0;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (alphabets[j] > alphabets[j+1]) {
                    temp = alphabets[j];
                    alphabets[j] = alphabets[j+1];
                    alphabets[j+1] = temp;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}