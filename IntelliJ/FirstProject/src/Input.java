import java.sql.SQLOutput;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);  //--> input

        System.out.print("Enter Name : ");
//        String name = input.next();
        String name = input.nextLine();
        System.out.println("Hi " + name);

        System.out.print("Enter Age : ");
        int age = input.nextInt();
        System.out.println("Your Age : " + age);

        System.out.print("Enter your GPA : ");
        float gpa = input.nextFloat();
        System.out.println("Your GPA is " + gpa);

    }
}
