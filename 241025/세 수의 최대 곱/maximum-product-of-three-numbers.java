import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static final int MAX_COUNT = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        int input;
        int positiveCount = 0;
        int negativeCount = 0;
        boolean zeroExists = false;
        for (int i = 0; i < n; i++) {
            input = sc.nextInt();

            if (input > 0) {
                positiveCount++;
            } else if (input < 0) {
                negativeCount++;
            } else {
                zeroExists = true;
            }

            nums[i] = input;
        }
        
        int[] pos = new int[positiveCount];
        int[] neg = new int[negativeCount];
        int tp = positiveCount;
        int tn = negativeCount;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos[--tp] = nums[i];
            } else if (nums[i] < 0) {
                neg[--tn] = nums[i];
            }
        }

        Arrays.sort(pos);
        Arrays.sort(neg);

        int ppp = Integer.MIN_VALUE;
        int ppn = Integer.MIN_VALUE;
        int pnn = Integer.MIN_VALUE;
        int nnn = Integer.MIN_VALUE;
        int zero = zeroExists ? 0 : Integer.MIN_VALUE;

        if (positiveCount >= 3) {
            ppp = pos[positiveCount-1] * pos[positiveCount-2] * pos[positiveCount-3];
        }
        if (positiveCount >= 2 && negativeCount >= 1) {
            ppn = pos[0] * pos[1] * neg[negativeCount-1];
        }
        if (positiveCount >= 1 && negativeCount >= 2) {
            pnn = pos[positiveCount-1] * neg[0] * neg[1];
        }
        if (negativeCount >= 3) {
            nnn = neg[negativeCount-1] * neg[negativeCount-2] * neg[negativeCount-3];
        }

        System.out.println(Math.max(Math.max(Math.max(Math.max(ppp, ppn), pnn), nnn), zero));
    }
}