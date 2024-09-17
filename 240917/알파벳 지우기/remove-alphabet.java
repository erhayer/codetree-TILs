import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(onlyNum(sc.nextLine()) + onlyNum(sc.nextLine()));
    }
    public static int onlyNum(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < 'a'){
                sb.append(str.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}