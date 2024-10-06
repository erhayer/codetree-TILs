import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] students = int[n+1];
        int temp;
        for (int i = 0; i < m; i++){
            temp = sc.nextInt();
            if (++students[temp] >= k){
                System.out.println(temp);
                break;
            }
        }
    }
}