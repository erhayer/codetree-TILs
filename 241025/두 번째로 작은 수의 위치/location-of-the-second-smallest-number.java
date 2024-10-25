import java.util.Scanner;
import java.util.Arrays;

class IndexedNum implements Comparable<IndexedNum>{
    int index;
    int num;

    public IndexedNum (int index, int num) {
        this.index = index;
        this.num = num;
    }

    @Override
    public int compareTo(IndexedNum indexedNum) {
        return this.num - indexedNum.num;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        IndexedNum[] nums = new IndexedNum[n];
        for (int i = 0; i < n; i++) {
            nums[i] = new IndexedNum(i+1, sc.nextInt());
        }

        Arrays.sort(nums);

        boolean isOnly = false;
        boolean isExist = false;
        IndexedNum firstNum = nums[0];
        IndexedNum secondNum = nums[0];
        for (int i = 0; i < n; i++) {
            if (!isExist && nums[i].num != firstNum.num) {
                isExist = true;
                secondNum = nums[i];
            }
            if (isExist) {
                if (i == n-1 || nums[i+1].num != secondNum.num) {
                    isOnly = true;
                }
                break;
            }
        }

        if (isExist && isOnly) {
            System.out.println(secondNum.index);
        } else {
            System.out.println(-1);
        }
    }
}