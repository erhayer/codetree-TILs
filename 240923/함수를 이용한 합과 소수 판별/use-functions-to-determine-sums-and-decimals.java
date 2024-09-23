import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = a; i <= b; i++){
            if (isMagicNumber(i)) count++;
        }

        System.out.println(count);
    }
    public static boolean isMagicNumber(int n){
        return isPrime(n) && isDigitSumOdd(n);
    }
    public static boolean isPrime(int n){
        if (n==1) return false;
        
        for (int i = 2; i < n; i++){
            if (n%i==0) return false;
        }
        
        return true;
    }
    public static boolean isDigitSumOdd(int n){
        return (n%10 + n%100/10 + n/100)%2 == 0;
    }
}