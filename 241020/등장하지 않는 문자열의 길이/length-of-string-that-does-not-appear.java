import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String str = sc.next();

        int min = n;
        boolean temp;
        for (int i = 1; i <= n; i++) {
            temp = true;
            for (int j = 0; j <= n - i; j++) {
                for (int k = 0; k <= n - i; k++) {
                    if (k == j) continue;

                    if (str.substring(j, j+i).equals(str.substring(k, k+i))) {
                        temp = false;
                        break;
                    }
                }

                if (!temp) {
                    break;
                }

                min = i;
            }

            if (min != n) break;
        }

        System.out.println(min);
    }
}