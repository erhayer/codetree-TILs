public class Main {
    public static void main(String[] args) {
        int a, b, c;
        a = 5;
        b = 6;
        c = 7;
        int tempb = b;
        int tempc = c;
        b = a;
        c = tempb;
        a = tempc;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}