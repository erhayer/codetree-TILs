import java.util.Scanner;

class Dev {
    boolean isInfected;
    int handshakeCount;

    public Dev() {
        this.isInfected = false;
        this.handshakeCount = 0;
    }
}

public class Main {
    public static final int MAX_T = 250;
    public static int MAX_HS;
    public static int INIT_DEV;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        MAX_HS = sc.nextInt();
        INIT_DEV = sc.nextInt();
        int m = sc.nextInt();

        Dev[] devs = new Dev[n+1];
        for (int i = 0; i <= n; i++){
            devs[i] = new Dev();
        }
        devs[INIT_DEV].isInfected = true;

        int[][] handshakes = new int[MAX_T+1][2];
        for (int i = 1; i <= MAX_T; i++){
            handshakes[i] = new int[]{-1, -1};
        }

        int t, x, y;
        for (int i = 0; i < m; i++){
            t = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            handshakes[t] = new int[]{x, y};
        }

        for (int i = 1; i <= MAX_T; i++){
            if (!(handshakes[i][0] == -1)) {
                handshake(devs[handshakes[i][0]], devs[handshakes[i][1]]);
            }
        }

        for (int i = 1; i <= n; i++){
            System.out.print(devs[i].isInfected ? 1 : 0);
        }
    }

    public static void handshake(Dev dev1, Dev dev2){
        if (dev1.isInfected && dev2.isInfected){
            dev1.handshakeCount++;
            dev2.handshakeCount++;
        } else if (dev1.isInfected && !dev2.isInfected){
            if (dev1.handshakeCount < MAX_HS){
                dev2.isInfected = true;
            }
            dev1.handshakeCount++;
        } else if (!dev1.isInfected && dev2.isInfected){
            if (dev2.handshakeCount < MAX_HS){
                dev1.isInfected = true;
            }
            dev2.handshakeCount++;
        }
    }
}