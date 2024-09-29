import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] students = new Student[n];
        for (int i = 0; i < n; i++){
            students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++){
            students[i].print();
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int a;
    int b;
    int c;
    public Student(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(Student student) {
        return this.a + this.b + this.c - student.a - student.b - student.c;
    }

    public void print() {
        System.out.println(this.name + " " + this.a + " " + this.b + " " + this.c);
    }
}