import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }

        if (isSubseq(arr1, arr2)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
    public static boolean isSubseq(int[] arr1, int[] arr2){
        for (int i = 0; i <= arr1.length - arr2.length; i++){
            boolean temp = true;
            for (int j = 0; j < arr2.length; j++){
                if (arr1[i+j]!=arr2[j]){
                    temp = false;
                    break;
                }
            }
            if (temp) return true;
        }
        return false;
    }
}