import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int oddCount = 0;
        int evenCount = 0;
        for (int i = 0; i < n; i++) {
            if(sc.nextInt()%2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int cnt = 0;

        if (oddCount > evenCount) {
            int exchangeToOdd = evenCount*2 + oddCount;
            if (exchangeToOdd % 3 == 0) {
                cnt = exchangeToOdd / 3 * 2;
            } else if (exchangeToOdd%3 == 1) {
                cnt = (exchangeToOdd - 4) / 3 * 2 + 1; 
            } else {
                cnt = (exchangeToOdd - 2) / 3 * 2 + 1;
            }
        } else if (oddCount < evenCount) {
            cnt = oddCount*2 + 1;
        } else {
            cnt = oddCount + evenCount;
        }

        System.out.println(cnt);
    }
}