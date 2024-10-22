import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lines = new int[n][2];

        for (int i = 0; i < n; i++) {
            lines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        
        String flag = "No";
        int x1, x2, maxX, minY;
        for (int i = 0; i < n; i++) {
            maxX = 0;
            minY = 100;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                x1 = lines[j][0];
                x2 = lines[j][1];

                //System.out.println(x1 + " " + x2);
                maxX = Math.max(x1, maxX);
                minY = Math.min(x2, minY);

                //System.out.println(i + " " + maxX + " " + minY);
            }

            if (maxX <= minY) {
                flag = "Yes";
                break;
            }
        }

        System.out.println(flag);
    }
}