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

        boolean isInitialized = false;

        int maxDist = 0;
        int firstDist = 0;
        int lastDist = 0;
        int tempDist = -1;
        int tempX1 = 0;
        int x1 = 0, x2 = 0;

        for (int i = 0; i < n; i++) {
            tempDist++;

            if (isInitialized){
                if (arr[i] == 1) {
                    if (tempDist > maxDist) {
                        maxDist = tempDist;
                        x1 = tempX1;
                        x2 = i;
                    }
                    tempDist = 0;
                    tempX1 = i;
                } else {
                    if (i == n-1) {
                        lastDist = tempDist;
                    }
                }
            } else {
                if (arr[i] == 1) {
                    firstDist = i;
                    isInitialized = true;
                    tempDist = 0;
                }
            }
        }
        //System.out.println((x1+x2)/2);
        if (maxDist/2 >= Math.max(firstDist, lastDist)) {
            arr[(x1+x2)/2] = 1;
        } else {
            if (firstDist >= lastDist) {
                arr[0] = 1;
            } else {
                arr[n-1] = 1;
            }
        }

        //System.out.println();
        //for (int i = 0; i < n; i++) {
        //    System.out.print(arr[i] + " ");
        //}
        //System.out.println();

        tempDist = -1;
        int minDist = n;
        isInitialized = false;
        for (int i = 0; i < n; i++) {
            tempDist++;
            if (isInitialized){
                if (arr[i] == 1) {
                    if (tempDist < minDist) {
                        minDist = tempDist;
                        //System.out.println(i + "!");
                    }
                    tempDist = 0;
                }
            } else {
                if (arr[i] == 1) {
                    isInitialized = true;
                    tempDist = 0;
                }
            }
        }

        System.out.println(minDist);
    }
}