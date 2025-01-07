import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Coin> coins = new ArrayList<>();
    public static int coinsCount = 0;

    public static Coin startCoin;
    public static Coin endCoin;

    public static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String row = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = row.charAt(j);

                if (c == 'S') {
                    startCoin = new Coin(0, i, j);
                } else if (c == 'E') {
                    endCoin = new Coin(10, i, j);
                } else if ( c >= '1' && c <= '9') {
                    coins.add(new Coin(c - '0', i, j));
                    coinsCount++;
                } 
            }
        }

        Collections.sort(coins);

        findMinimumDistance(0, -1, 0);

        if (minDist == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist);
        }
    }

    public static int calcDistance(Coin c1, Coin c2) {
        return Math.abs(c1.r - c2.r) + Math.abs(c1.c - c2.c);
    }

    public static void findMinimumDistance(int coinCnt, int lastCoinIndex, int dist) {
        if (coinCnt >= 3) {
            minDist = Math.min(dist + calcDistance(coins.get(lastCoinIndex), endCoin), minDist);
            return;
        }

        if (coinCnt == 0) {
            for (int i = lastCoinIndex + 1; i < coinsCount; i++) {
                findMinimumDistance(coinCnt + 1, i, dist + calcDistance(startCoin, coins.get(i)));    
            }
        } else {
            for (int i = lastCoinIndex + 1; i < coinsCount; i++) {
                findMinimumDistance(coinCnt + 1, i, dist + calcDistance(coins.get(lastCoinIndex), coins.get(i)));    
            }
        }
        
    }
}

class Coin implements Comparable<Coin> {
    int num;
    int r;
    int c;

    public Coin(int num, int r, int c) {
        this.num = num;
        this.r = r;
        this.c = c;
    }

    @Override
    public int compareTo(Coin o) {
        return this.num - o.num;
    }
}