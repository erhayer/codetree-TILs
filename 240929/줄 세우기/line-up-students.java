import java.util.Scanner;
import java.util.Arrays;

class Student implements Comparable<Student> {
    int h;
    int w;
    int num;

    public Student(int h, int w, int num){
        this.h = h;
        this.w = w;
        this.num = num;
    }

    @Override
    public int compareTo(Student student) {
        if (student.h == this.h){
            if (this.w == student.w) return this.num - student.num;
            return student.w = this.w;
        }
        return student.h - this.h;
    }

    public String toStr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.h).append(" ").append(this.w).append(" ").append(this.num);
        String str = sb.toString();
        return str;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] arr = new Student[n];

        for (int i = 0; i < n; i++){
            arr[i] = new Student(sc.nextInt(), sc.nextInt(), i + 1);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++){
            System.out.println(arr[i].toStr());
        }
    }
}