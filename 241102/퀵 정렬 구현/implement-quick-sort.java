import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quicksort(0, n-1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static int partition(int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for (int j = 0; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
            }
        }

        swap(i+1, high);

        return i+1;
    }

    public static void quicksort(int low, int high) {
        if (high > low) {
            int pivot = partition(low, high);

            quicksort(low, pivot-1);
            quicksort(high, pivot-1);
        }

        return;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return;
    }
}