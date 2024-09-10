import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st1 = sc.nextLine();
        double d1 = Double.parseDouble(sc.nextLine());
        double d2 = Double.parseDouble(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        sb.append(st1).append("\n").append(String.format("%.2f", d1)).append("\n").append(String.format("%.2f", d2)).append("\n");
        System.out.println(sb.toString());
    }
}