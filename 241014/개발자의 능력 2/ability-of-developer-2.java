import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] devs = new int[6];
        int sum = 0;
        int t;
        for (int i = 0; i < 6; i++){
            t = sc.nextInt();
            devs[i] = t;
            sum += t;
        }
        
        int min = Integer.MAX_VALUE;
        int a, b, c;
        for (int i = 1; i < 6; i++){
            a = devs[0] + devs[i];
            int secondf = i == 1 ? 2 : 1;
            for (int j = secondf + 1; j < 6; j++){
                if (j == i) continue;
                b = devs[secondf] + devs[j];

                c = sum - a - b;

                //System.out.println(a + " " + b + " " + c);
                //System.out.println(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));

                min = Math.min(Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)), min);
            }
        }


        System.out.println(min);
    }
}