import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] students = new int[n+1];
        for (int i = 1; i <=n; i++){
            students[i] = 0;
        }

        int query;
        int magic_student = -1;
        for (int i = 0; i < m; i++) {
            query = sc.nextInt();
            students[query]++;
            if (students[query] == k){
                magic_student = query;
                break;
            }
        }

        System.out.println(magic_student);
    }
}