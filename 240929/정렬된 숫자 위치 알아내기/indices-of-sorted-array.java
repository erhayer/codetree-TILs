import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Wrapper[] arr = new Wrapper[n];

        for (int i = 0; i < n; i++){
            arr[i] = new Wrapper(sc.nextInt(), i + 1);
        }

        Arrays.sort(arr);

        int[] num_to_idx = new int[n+1];

        for (int i = 0; i < n; i++){
            num_to_idx[arr[i].num] = i + 1;
        }

        for (int i = 1; i <= n; i++){
            System.out.print(num_to_idx[i] + " ");
        }
    }
}

class Wrapper implements Comparable<Wrapper> {
    int n;
    int num;

    public Wrapper(int n, int num) {
        this.n = n;
        this.num = num;
    }

    @Override
    public int compareTo(Wrapper wrapper) {
        return this.n - wrapper.n;
    }
}