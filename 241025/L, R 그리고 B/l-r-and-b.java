import java.util.Scanner;

public class Main {
    public static final int MAX = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char input;
        String str;

        int lR = 0;
        int lC = 0;
        int rR = 0;
        int rC = 0;
        int bR = 0;
        int bC = 0;
        for (int i = 0; i < MAX; i++) {
            str = sc.next();
            for (int j = 0; j < MAX; j++) {
                input = str.charAt(j);
                if (input == 'L') {
                    lR = i;
                    lC = j;
                } else if (input == 'R') {
                    rR = i;
                    rC = j;
                } else if (input == 'B') {
                    bR = i;
                    bC = j;
                }
            }
        }
        //4 2, 8 5
        int dist = Math.abs(lR - bR) + Math.abs(lC - bC) - 1;
        if ((lR == rR && rR == bR && ((lC < rC && rC < bC) || (lC > rC && rC > bC))) || (lC == rC && rC == bC) && ((lR < rR && rR < bR) || (lR > rR && rR > bR))) {
            dist += 2;
        }

        System.out.println(dist);
    }
}