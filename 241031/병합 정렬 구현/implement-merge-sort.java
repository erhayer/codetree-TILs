import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    public static void mergeSort(int low, int high) {
        if (high > low) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high) {
        int i = low;
        int j = mid+1;

        ArrayList<Integer> mergedArr = new ArrayList<>();

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArr.add(arr[i++]);
            } else {
                mergedArr.add(arr[j++]);
            }
        }

        while (i <= mid) {
            mergedArr.add(arr[i++]);
        }

        while (j <= high) {
            mergedArr.add(arr[j++]);
        }

        int index = 0;
        for (int k = low; k <= high; k++) {
            arr[k] = mergedArr.get(index++);
        }
    }
}