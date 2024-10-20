import java.util.Scanner;

public class Main {
    public static final int MAX_X = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }


        boolean temp;
        int min = 10000;
        int t;
        for (int i = 1; i <= MAX_X; i++) {
            temp = true;
            t = i;
            for (int j = 0; j < n; j++) {
                t *= 2;
                if (t < arr[j][0] || t > arr[j][1]) {
                    temp = false;
                    break;
                }
                
            }

            if (temp) {
                min = i;
                break;
            }
        }

        System.out.println(min);
    }
}