import java.util.Scanner;

public class Main {
    public static int n;
    public static int m;
    
    public static int[] com;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        com = new int[m];
        

        choose(0, 0);
    }

    public static void choose(int cnt, int lastNum) {
        if (cnt >= m) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < m; i++) {
                sb.append(com[i]).append(" "); 
            }

            System.out.println(sb);

            return;
        }

        for (int i = lastNum + 1; i <= n; i++) {
            com[cnt] = i;
            choose(cnt + 1, i);
        }
    }
}