import java.util.Scanner;

class Tile {
    char color;
    public Tile() {
        this.color = 'G';
    }
    public void paintW() {
        this.color = 'W';        
    }
    public void paintB() {
        this.color = 'B';        
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Tile[] tiles = new Tile[200001];
        for (int i = 0; i < 200001; i++) tiles[i] = new Tile();
        int position = 100000;

        int x;
        char com;
        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            com = sc.next().charAt(0);

            if (com == 'R'){
                for (int j = position; j < position + x; j++){
                    tiles[j].paintB();
                }
                position += x - 1;
            } else {
                for (int j = position - x + 1; j <= position; j++){
                    tiles[j].paintW();
                }
                position -= x - 1;
            }
        }

        int b = 0, w = 0;
        for (int i = 0; i < 200001; i++) {
            if (tiles[i].color == 'B') b++;
            if (tiles[i].color == 'W') w++;
        }

        System.out.println(w + " " + b);
    }
}