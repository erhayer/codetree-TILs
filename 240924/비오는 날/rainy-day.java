import java.util.Scanner;

class Forecast {
    String date;
    String day;
    String weather;
    public Forecast(String date, String day, String weather){
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
    public void print(){
        System.out.println(date + " " + day + " " + weather);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Forecast closest = new Forecast("2100-12-31", "Sun", "Rain");
        Forecast temp;
        for(int i = 0; i < n; i++){
            temp = new Forecast(sc.next(), sc.next(), sc.next());
            if (closest.date.compareTo(temp.date) >= 0 && temp.weather.compareTo("Rain") == 0){
                closest = temp;
            }
        }
        closest.print();
    }
}