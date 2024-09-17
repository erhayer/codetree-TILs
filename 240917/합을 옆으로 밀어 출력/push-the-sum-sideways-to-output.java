import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        String str = Integer.toString(sum);

        sb.append(str.substring(1)).append(str.charAt(0));
        System.out.println(sb);
    }
}