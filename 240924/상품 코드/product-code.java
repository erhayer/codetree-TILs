import java.util.Scanner;

class Product {
    String name;
    int code;
    public Product(){
        this.name = "codetree";
        this.code = 50;
    }
    public Product(String name, int code){
        this.name = name;
        this.code = code;
    }
    public void print(){
        System.out.println("product " + this.code + " is " + this.name);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product product1 = new Product();
        Product product2 = new Product(sc.next(), sc.nextInt());
        
        product1.print();
        product2.print();
    }
}