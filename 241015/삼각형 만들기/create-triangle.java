import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dots = new int[n][2];
        for (int i = 0; i < n; i++){
            dots[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }

        int max = Integer.MIN_VALUE;
        int[] dot1;
        int[] dot2;
        int[] dot3;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    dot1 = dots[i];
                    dot2 = dots[j];
                    dot3 = dots[k];

                    if (dot1[0] == dot2[0] && dot2[0] == dot3[0]) {
                        //System.out.println("a " + i + " " + j + " " + k);
                        continue;
                    }
                    if (dot1[1] == dot2[1] && dot2[1] == dot3[1]) {
                        //System.out.println("b " + i + " " + j + " " + k);
                        continue;
                    }
                    if (dot1[0] != dot2[0] && dot2[0] != dot3[0] && dot3[0] != dot1[0]) {
                        //System.out.println("c " + i + " " + j + " " + k);
                        continue;
                    }
                    if (dot1[1] != dot2[1] && dot2[1] != dot3[1] && dot3[1] != dot1[1]) {
                        //System.out.println("d " + i + " " + j + " " + k);
                        continue;
                    }
                    //System.out.println(i + " " + j + " " + k);
                    max = Math.max(calTri(dot1, dot2, dot3), max);
                }
            }
        }

        System.out.println(max);
    }

    public static int calTri(int[] dot1, int[] dot2, int[] dot3) {
        return Math.abs((dot1[0]*dot2[1] + dot2[0]*dot3[1] + dot3[0]*dot1[1]) - (dot2[0]*dot1[1] + dot3[0]*dot2[1] + dot1[0]*dot3[1]));
    }
}