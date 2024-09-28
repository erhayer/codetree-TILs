import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(lcms(arr, 1, arr[0]));
    }
    public static int gcd(int n, int m){
        if (Math.max(n, m) % Math.min(n, m) == 0) return Math.min(n, m);
        return gcd(Math.min(n, m), Math.max(n, m) % Math.min(n, m));
    }
    public static int lcm(int n, int m){
        return n*m/gcd(n,m);
    }
    public static int lcms(int[] arr, int index, int n){
        if (arr.length == index){
            return n;
        }
        return lcms(arr, index+1, lcm(n, arr[index]));
    }
}