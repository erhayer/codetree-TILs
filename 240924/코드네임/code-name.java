import java.util.Scanner;

class Agent {
    char codename;
    int score;
    public Agent(){
        this.codename = 'A';
        this.score = 0;
    }
    public Agent(char codename, int score){
        this.codename = codename;
        this.score = score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Agent[] agents = new Agent[5];
        for (int i = 0; i < 5; i++){
            agents[i] = new Agent(sc.next().charAt(0), sc.nextInt());
        }
        Agent min = agents[0];
        for (int i = 1; i < 5; i++){
            if (agents[i].score < min.score) min = agents[i];
        }
        System.out.println(min.codename + " " + min.score);
    }
}