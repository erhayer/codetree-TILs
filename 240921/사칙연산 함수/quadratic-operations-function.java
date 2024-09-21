import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        String op = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        if (op.compareTo("+")==0){
            System.out.println(a + " " + op + " " + c + " = " + add(a, c));
        } else if(op.compareTo("-")==0){
            System.out.println(a + " " + op + " " + c + " = " + sub(a, c));
        } else if(op.compareTo("*")==0){
            System.out.println(a + " " + op + " " + c + " = " + mul(a, c));
        } else if(op.compareTo("/")==0){
            System.out.println(a + " " + op + " " + c + " = " + div(a, c));
        } else {
            System.out.println("False");
        }
    }
    public static int add(int a, int c){
        return a + c;
    }
    public static int sub(int a, int c){
        return a - c;
    }
    public static int mul(int a, int c){
        return a * c;
    }
    public static int div(int a, int c){
        return a / c;
    }
}