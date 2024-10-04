import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        int[] arr = new int[2000];
        for (int i = 0; i < 2000; i++) {
            arr[i] = 0;
        }

        int position = 1000;
        int x;
        char com;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            com = sc.next().charAt(0);

            if (com == 'R') {
                for (int j = position; j < position + x; j++){
                    arr[j]++;
                }
                position += x;
            } else {
                for (int j = position - x; j < position; j++){
                    arr[j]++;
                }
                position -= x;
            }
        }

        int count = 0;
        for (int i = 0; i < 2000; i++) {
            if (arr[i] >= 2) count++;
        }

        System.out.println(count);
    }
}