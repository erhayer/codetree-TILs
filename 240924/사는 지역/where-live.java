import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class User {
    String name;
    String zipcode;
    String city;
    public User(String name, String zipcode, String city){
        this.name = name;
        this.zipcode = zipcode;
        this.city = city;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        User[] users = new User[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            users[i] = new User(st.nextToken(), st.nextToken(), st.nextToken());
        }

        User min = users[0];
        for (int i = 1; i < n; i++){
            if (users[i].name.compareTo(min.name) > 0){
                min = users[i];
            }
        }

        System.out.println("name " + min.name);
        System.out.println("addr " + min.zipcode);
        System.out.println("city " + min.city);
    }
}