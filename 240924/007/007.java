import java.util.Scanner;

class Secret {
    private String secret_code;
    private char meeting_point;
    private int time;
    public Secret(String _secret_code, char _meeting_point, int _time){
        this.secret_code = _secret_code;
        this.meeting_point = _meeting_point;
        this.time = _time;
    }
    public String getSecretCode(){
        return this.secret_code;
    }
    public char getMeetingPoint(){
        return this.meeting_point;
    }
    public int getTime(){
        return this.time;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Secret secret = new Secret(sc.next(), sc.next().charAt(0), sc.nextInt());
        System.out.println("secret code : " + secret.getSecretCode());
        System.out.println("meeting point : " + secret.getMeetingPoint());
        System.out.println("time : " + secret.getTime());
    }
}