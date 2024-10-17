import java.util.Scanner;

public class Function {
    public static void main(String[] args) {

        int num = Input();

//        Mul_Table(num);  //--> Namta...

//        System.out.println(Odd_Sum(num));  //--> Odd_sum

        long fact = Fact(num);
        System.out.println(fact);  //--> Factorial


//        int sum = Sum_Digit(num);
//        System.out.println(sum);

    }

    public static int Sum_Digit(int d){
        int sum =0;
        while(d > 0){
            sum = sum + d%10;
            d = d/10;
        }
        return sum;
    }

    public static long Fact(int c) {
        long fac = 1;
        for (int i = c; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }

    public static int Odd_Sum(int b) {
        int sum = 0;
        for (int i = 0; i <= b; i++) {
            if (i % 2 != 0)
                sum += i;
        }
        return sum;
    }

    public static void Mul_Table(int a) {
        for (int i = 1; i <= 10; i++)
            System.out.println(a + " * " + i + " = " + a * i);
    }

    public static int Input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number : ");
        return input.nextInt();
    }
}
