import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            students[i] = new Student(i + 1, sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++) {
            students[i].print();
        }
    }
}

class Student implements Comparable<Student> {
    int n;
    int h;
    int w;

    public Student(int n, int h, int w) {
        this.n = n;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Student student) {
        if (this.h == student.h) return student.w - this.w;
        return this.h - student.h;
    }

    public void print() {
        System.out.println(this.h + " " + this.w + " " + this.n);
    }
}