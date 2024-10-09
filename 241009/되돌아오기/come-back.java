import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x = 0, y = 0;

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        int t = 0;
        int dir, len;
        boolean isReturned = false;
        for (int i = 0; i < n; i++){
            dir = charToDir(sc.next().charAt(0));
            len = sc.nextInt();
            for (int j = 0; j < len; j++){
                x += dx[dir];
                y += dy[dir];
                t++;
                if (x == 0 && y == 0){
                    isReturned = true;
                    break;
                }
            }
            if (isReturned) break;
        }

        System.out.println(isReturned ? t : -1);
    }
    public static int charToDir(char c){
        if (c == 'N') return 0;
        if (c == 'E') return 1;
        if (c == 'S') return 2;
        return 3;
    }
}