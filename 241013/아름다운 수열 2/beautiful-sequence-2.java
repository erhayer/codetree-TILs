import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);

        int cnt = 0;
        if (n >= m) {
            int[] temp;
            for (int i = 0; i <= n - m; i++){
                temp = Arrays.copyOfRange(a, i, i+m);
                Arrays.sort(temp);

                for (int j = 0; j < m; j++){
                    if (temp[j] != b[j]){
                        cnt--;
                        break;
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }    
}