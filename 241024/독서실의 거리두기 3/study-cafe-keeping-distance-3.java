import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        String str = sc.next();

        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i)-'0';
        }

        int maxDist = 0;
        int t1 = 0;
        int tempDist = 1;
        int x1 = 0, x2 = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 1) {
                if (tempDist > maxDist) {
                    x1 = t1;
                    x2 = i;
                    maxDist = tempDist;
                }
                tempDist = 0;
                t1 = i;
            }
            tempDist++;
        }
        //System.out.println((x1+x2)/2);
        arr[(x1+x2)/2] = 1;

        tempDist = 1;
        int minDist = n;
        for (int i = 1; i < n; i++) {
            if (arr[i] == 1) {
                if (tempDist < minDist) {
                    minDist = tempDist;

                    tempDist = 0;
                }
            }
            tempDist++;
        }

        System.out.println(minDist);
    }
}