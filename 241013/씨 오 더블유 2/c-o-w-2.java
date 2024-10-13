import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //input
        int n = sc.nextInt();
        String str = sc.next();

        //brute force
        int cnt = 0;
        for (int i = 0; i < n-2; i++) {
            if (str.charAt(i) == 'C'){
                for (int j = i + 1; j < n-1; j++) {
                    if (str.charAt(j) == 'O'){
                        for (int k = j+1; k < n; k++){
                            if (str.charAt(k) == 'W') cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}