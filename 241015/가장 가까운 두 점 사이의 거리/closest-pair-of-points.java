import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                min = Math.min(calDis(arr[i][0], arr[i][1], arr[j][0], arr[j][1]), min);
            }
        }

        System.out.println(min);
    }

    public static int calDis(int x1, int y1, int x2, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}