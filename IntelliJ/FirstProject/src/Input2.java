import java.util.Scanner;

public class Input2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter num x : ");
        int x= input.nextInt();
//        System.out.print("Enter num y : ");
//        int y= input.nextInt();
//        System.out.print("Enter num z : ");
//        int z= input.nextInt();
//
//        if(x>=y && x>=z)
//            System.out.println(x+" is Larger.");
//        else if(y>=x && y>=z)
//            System.out.println(y+" is Larger.");
//        else
//            System.out.println(z+" is Larger.");

        if(x%4==0 && x%100!=0 || x%400==0)
            System.out.println(x+" is leapYear.");
        else
            System.out.println(x+" is not leapYear.");
    }
}
