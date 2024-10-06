import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int max = 0;
        int count = 0;
        int temp;
        for (int i=0; i < n; i++){
            temp = sc.nextInt();
            if (temp > t){
                count++;
            } else {
                count = 0;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }
}