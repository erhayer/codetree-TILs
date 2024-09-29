import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int math;
    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student){
        if (this.kor == student.kor){
            if (this.eng == student.eng){
                return -this.math + student.math;
            }
            return -this.eng + student.eng;
        }
        return -this.kor + student.kor;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.kor).append(" ").append(this.eng).append(" ").append(this.math);
        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Student[] students = new Student[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students);

        for (int i = 0; i < n; i++){
            students[i].print();
        }
    }
}