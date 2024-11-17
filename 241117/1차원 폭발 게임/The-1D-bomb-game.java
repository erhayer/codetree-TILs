import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean exploded = true;
        int endOfIndex = n;
        while (exploded) {
            exploded = false;

            int currNum = 0;
            int numCount = 0;
            int currNumStartingIndex = -1;

            for (int i = 0 ; i < endOfIndex; i++) {
                if (currNum != arr[i]) {
                    if (numCount >= m) {
                        for (int j = currNumStartingIndex; j < currNumStartingIndex+numCount; j++) {
                            arr[j] = 0;
                        }

                        exploded = true;
                    }

                    numCount = 0;
                    currNum = arr[i];
                    currNumStartingIndex = i;
                }

                numCount++;
            }

            if (numCount >= m) {
                for (int j = currNumStartingIndex; j < currNumStartingIndex+numCount; j++) {
                    arr[j] = 0;
                }

                exploded = true;
            }

            int tempIndex = 0;
            for (int i = 0; i < endOfIndex; i++) {
                if (arr[i] != 0) {
                    arr[tempIndex++] = arr[i];
                }
            }

            endOfIndex = tempIndex;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < endOfIndex; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(endOfIndex);
        System.out.println(sb);
    }
}