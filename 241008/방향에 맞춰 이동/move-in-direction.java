import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int x = 0, y = 0;

        char d;
        int t;
        for (int i = 0; i < n; i++){
            d = sc.next().charAt(0);
            t = sc.nextInt();

            for (int j = 0; j < t; j++){
                if (x == 'N'){
                    x += dx[0];
                    y += dy[0];
                } else if (x =='E'){
                    x += dx[1];
                    y += dy[1];
                } else if (x =='S'){
                    x += dx[2];
                    y += dy[2];
                } else {
                    x += dx[3];
                    y += dy[3];
                }
            }
        }

        System.out.println(x + " " + y);
    }
}