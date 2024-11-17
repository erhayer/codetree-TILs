import java.util.Scanner;

public class Main {
    public static int MAX_H = 100;
    public static int[] arr = new int[MAX_H];
    public static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int s1 = sc.nextInt();
        int e1 = sc.nextInt();
        int s2 = sc.nextInt();
        int e2 = sc.nextInt();

        
        zenga(s1-1, e1-1);
        zenga(s2-1, e2-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(n);
        System.out.println(sb);
    }

    public static void zenga(int s1, int e) {
        int[] temp = new int[MAX_H];
        int endOfIndex = 0;
        for (int i = 0; i < n; i++) {
            if (i >= s1 && i <= e) continue;
            
            temp[endOfIndex++] = arr[i];
        }

        for (int i = 0; i < MAX_H; i++) {
            arr[i] = temp[i];
        }

        n = endOfIndex;
    }
}