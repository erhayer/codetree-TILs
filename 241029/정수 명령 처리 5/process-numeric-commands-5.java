import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st;
        String inst;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inst = st.nextToken();
            if (inst.equals("size")) {
                System.out.println(arr.size());
            } else if (inst.equals("pop_back")) {
                arr.remove(arr.size()-1);
            } else if (inst.equals("get")) {
                System.out.println(arr.get(Integer.parseInt(st.nextToken())-1));
            } else {
                arr.add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}