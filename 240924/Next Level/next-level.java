import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class User {
    String id;
    int level;
    public User(){
        this.id = "codetree";
        this.level = 10;
    }
    public User(String id, int level){
        this.id = id;
        this.level = level;
    }
    public void printUser(){
        System.out.println("user " + this.id + " lv " + this.level);
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        User user1 = new User();
        User user2 = new User(st.nextToken(), Integer.parseInt(st.nextToken()));
        user1.printUser();
        user2.printUser();
    }
}