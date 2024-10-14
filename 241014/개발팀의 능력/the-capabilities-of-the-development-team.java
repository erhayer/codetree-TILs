import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] devs = new int[5];
        int sum = 0;
        int t;
        for (int i = 0; i < 5; i++){
            t = sc.nextInt();
            devs[i] = t;
            sum += t;
        }
        
        int min = Integer.MAX_VALUE;
        int a, b, c;
        for (int i = 0; i < 5; i++){
            a = devs[i];
            int te = i == 0 ? 1 : 0;
            for (int j = 1; j < 5; j++){
                if (j == i) continue;
                b = devs[te] + devs[j];

                c = sum - a - b;

                if (a == b || b == c) continue;
                min = Math.min(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)), min);
            }
        }


        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}