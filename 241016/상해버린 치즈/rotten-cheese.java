import java.util.Scanner;

public class Main {
    public static int n, m, d, s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        d = sc.nextInt();
        s = sc.nextInt();

        //사람당 t에 따른 치즈 종류별 먹은 횟수
        int[][][] person_arr = new int[n+1][101][m+1];
        //후보 치즈당 감염 수
        int[] cheese_count = new int[m+1];
        for (int i = 1; i <= m; i++) {
            cheese_count[i] = 0;
        }

        int p, c, t;
        for (int i = 0; i < d; i++) {
            p = sc.nextInt();
            c = sc.nextInt();
            t = sc.nextInt();

            person_arr[p][t][c] = 1;
        }


        for (int i = 0; i < s; i++) {
            p = sc.nextInt();
            t = sc.nextInt();

            for (int j = 1; j < t; j++) {
                for (int k = 1; k <= m; k++) {
                    if (person_arr[p][j][k] > 0){
                        cheese_count[k]++;
                        //System.out.println(p +" ate " + k + " at " + j + " before " + t);
                    }
                }
            }
        }

//        for (int i = 1; i <= m; i++) {
//            System.out.println(cheese_count[i]);
//        }

        int max_cheese_cnt = 0;
        for (int i = 1; i <= m; i++) {
            max_cheese_cnt = Math.max(cheese_count[i], max_cheese_cnt);
        }

        int max = 0;
        int temp;
        for (int i = 1; i <= m; i++) {
            temp = 0;
            if (cheese_count[i] == max_cheese_cnt) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= 100; k++) {
                        if (person_arr[j][k][i] == 1) {
                            temp++;
                            break;
                        }
                    }
                }
            }

            max = Math.max(temp, max);
        }

        System.out.println(max);
    }
}