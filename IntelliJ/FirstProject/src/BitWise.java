import java.util.Scanner;

public class BitWise{
    public static void main(String[] args){
        System.out.println("Welcome : ");

        Scanner input = new Scanner(System.in);

        System.out.print(" Enter 1st number : ");
        int a = input.nextInt();
//        System.out.print(" Enter 2nd number : ");
//        int b = input.nextInt();

//        int c = a & b;  //--> Bitwise AND
//        System.out.println(" Result is "+ c);
//
//        int d = a | b;  //--> Bitwise OR
//        System.out.println(" Result is "+ d);
//
//        int e = a ^ b;  //--> Bitwise X-OR
//        System.out.println(" Result is "+ e);
//
//        int f = ~b;  //--> Bitwise Complement
//        System.out.println(" Result is "+ f);

//        int x = a << 2;  //--> Bitwise Left-Shift
//        System.out.println(" Result is "+ x);

//        int y = a >> 1;  //--> Bitwise Right-Shift
//        System.out.println(" Result is "+ y);

        if((a & 1) == 0)
            System.out.println(" Even");
        else
            System.out.println(" Odd");
        System.out.println(" Odd");

    }
}
