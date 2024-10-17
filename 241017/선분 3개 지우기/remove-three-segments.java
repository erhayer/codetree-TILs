import java.util.Scanner;

public class Main {
    public static final int MAX_X = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            lines[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }


        int cnt = 0;
        int[] temp;
        int isCross;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    temp = new int[MAX_X+1];
                    isCross = 1; 
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;

                        for (int x = lines[l][0]; x <= lines[l][1]; x++) {
                            temp[x]++;
                        }
                    }

                    for (int t = 0; t <= MAX_X; t++) {
                        if (temp[t] >= 2) {
                            isCross = 0;
                            break;
                        }
                    }

                    cnt += isCross;
                }
            }
        }

        System.out.println(cnt);
    }

}