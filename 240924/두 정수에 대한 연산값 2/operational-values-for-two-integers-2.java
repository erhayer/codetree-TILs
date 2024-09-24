import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ab = new int[2];
        ab[0] = sc.nextInt();
        ab[1] = sc.nextInt();

        change(ab);

        System.out.println(ab[0] + " " + ab[1]);
    }
    public static void change(int[] ab){
        if (ab[0] >= ab[1]){
            ab[0] *= 2;
            ab[1] += 10;
        } else {
            ab[1] *= 2;
            ab[0] += 10;
        }
    }
}