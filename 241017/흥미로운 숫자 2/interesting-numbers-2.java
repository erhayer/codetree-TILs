import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int cnt = 0;
        for (int i = x; i <= y; i++) {
            if (isMagicNumber(i)) cnt++;
        }

        System.out.println(cnt);
    }
    
    public static boolean isMagicNumber(int n) {
        String str = Integer.toString(n);

        int[] num_cnt = new int[10];

        for (int i = 0; i < str.length(); i++){
            num_cnt[str.charAt(i) - '0']++;
        }
        
        int cnt = 0;
        int one = 2;
        for (int i = 0; i < 10; i++) {
            if (num_cnt[i] > 0){
                cnt++;
                one = Math.min(num_cnt[i], one); 
            }
        }

        if (cnt == 2 && one == 1) {
            return true;
        }
        return false;
    }
}