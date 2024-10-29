import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> arr = new LinkedList<>();
        StringTokenizer st;
        String inst;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inst = st.nextToken();
            if (inst.equals("push_front")) {
               arr.addFirst(Integer.parseInt(st.nextToken()));
            } else if (inst.equals("push_back")) {
                arr.addLast(Integer.parseInt(st.nextToken()));
            } else if (inst.equals("pop_front")) {
                System.out.println(arr.pollFirst());
            } else if (inst.equals("pop_back")) {
                System.out.println(arr.pollLast());
            } else if (inst.equals("size")) {
                System.out.println(arr.size());
            } else if (inst.equals("empty")) {
                System.out.println(arr.isEmpty() ? 1 : 0);
            } else if (inst.equals("front")) {
                System.out.println(arr.peekFirst());
            } else if (inst.equals("back")) {
                System.out.println(arr.peekLast());
            }
        }
    }
}