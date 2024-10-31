import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static final int MAX_LENGTH = 6;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer>[] buckets;
        LinkedList<Integer> tempSortedArr;
        for (int i = 1; i <= MAX_LENGTH; i++) {
            buckets = new LinkedList[10];

            for (int j = 0; j < 10; j++) {
                buckets[j] = new LinkedList<Integer>();
            }

            tempSortedArr = new LinkedList<Integer>();

            for (int j = 0; j < n; j++) {
                //System.out.print(getDigit(arr[j], i));
                buckets[getDigit(arr[j], i)].add(arr[j]);
                //System.out.println("!");
            }

            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < buckets[j].size(); k++) {
                    tempSortedArr.add(buckets[j].get(k));
                }
            }

            for (int j = 0; j < n; j++) {
                arr[j] = tempSortedArr.get(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int getDigit(int n, int d) {
        for (int i = 0; i < d-1; i++) {
            n /= 10;
        }

        return n%10;
    }
}