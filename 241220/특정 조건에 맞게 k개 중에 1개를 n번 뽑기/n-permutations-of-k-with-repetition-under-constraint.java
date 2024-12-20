import java.util.Scanner;

public class Main {
    public static int[] combination;
    public static int k;
    public static int n;

    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        combination = new int[n];

        findCombinations(0);

        System.out.println(answer);
    }

    public static void findCombinations(int index) {
        if (index >= n) {
            answer.append(comToString()).append("\n");
            return;
        }

        for (int i = 1; i <= k; i++) {
            if (index < 2 || !(combination[index - 2] == combination[index - 1] && combination[index - 1] == i)) {
                combination[index] = i;
                findCombinations(index + 1);
            }
        }
    }

    public static String comToString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(combination[i]).append(" ");
        }

        return sb.toString();
    }
}