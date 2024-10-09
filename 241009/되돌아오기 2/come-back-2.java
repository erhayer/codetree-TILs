import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String queries = sc.next();

        int x = 0, y = 0;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int t = 0;
        int dir = 0;
        boolean isReturned = false;
        char query;
        for (int i = 0; i < queries.length(); i++){
            query = queries.charAt(i);
            if (query == 'R') {
                dir = (dir + 1) % 4;
            } else if (query == 'L') {
                dir = (dir - 1 + 4) % 4;
            } else {
                x += dx[dir];
                y += dy[dir];
            }
            t++;

            if (x == 0 && y == 0) {
                isReturned = true;
                break;
            }
        }

        System.out.println(isReturned ? t : -1);
    }
}