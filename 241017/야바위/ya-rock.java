import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] queries = new int[n][3];
        for (int i = 0; i < n; i++) {
            queries[i] = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
        }

        int[] cups = new int[3 + 1];
        int temp;
        int sum;
        int max = 0;
        for (int i = 1; i <= 3; i++) {
            // cup setting
            for (int j = 1; j <= 3; j++) {
                if (i == j) {
                    cups[j] = 1;
                } else {
                    cups[j] = 0;
                }
            }

            sum = 0;
            //System.out.println(cups[1] + " " + cups[2] + " " + cups[3]);

            for (int j = 0; j < n; j++) {
                temp = cups[queries[j][0]];
                cups[queries[j][0]] = cups[queries[j][1]];
                cups[queries[j][1]] = temp;

                //System.out.println(cups[1] + " " + cups[2] + " " + cups[3]);

                sum += cups[queries[j][2]]; 
            }

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}