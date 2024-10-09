import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String queries = sc.next();

        int x = 0;
        int y = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int dirnum = 0;

        char query;
        for (int i = 0; i < queries.length(); i++){
            query = queries.charAt(i);
            if (query == 'R') {
                dirnum = (dirnum+1)%4;
            } else if (query == 'L'){
                dirnum = (dirnum - 1 + 4) % 4;
            } else {
                x += dx[dirnum];
                y += dy[dirnum];
            }
        }

        System.out.println(x + " " + y);
    }
}