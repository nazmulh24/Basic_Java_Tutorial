import java.util.Scanner;

public class LoopProblem {
    public static void main(String[] args) {
        int num = Input();
//        int num2 = Input();

//        long Fact = Factorial(num);  //--> Factorial..
//        System.out.println(Fact);

//        int Sum = SumDigit(num);
//        System.out.println(Sum);

//        int lcm = LCM(num, num2);
//        System.out.println(lcm);

//        int gcd = GCD(num, num2);
//        System.out.println(gcd);

//        boolean isPrime = Prime(num);
//        if(isPrime)
//            System.out.println("Prime number!");
//        else
//            System.out.println("Not Prime!");


//        int rev = RevNum(num);
//        System.out.println(rev);

//        Fibonacci(num);

//        Armstrong(num);

//        Palindrome(num);

        int c;
    }


    public static void Palindrome(int x) {
        int y = RevNum(x);
        if (x == y) System.out.println("Palindrome!");
        else System.out.println("Not Palindrome!");
    }

    public static void Armstrong(int num) {
        int digit = noOfDigit(num);
        int f_num = 0;
        int numCopy = num;
        while (numCopy > 0) {
            int d = numCopy % 10;
            numCopy/=10;
            f_num += pow(d, digit);
        }
        if(num == f_num) System.out.println("This number is Armstrong.");
        else System.out.println("This number is not Armstrong.");
    }

    public static int pow(int num1, int num2) {
        int result = 1;
        int i = 0;
        while(i < num2){
            result = result * num1;
            i++;
        }
        return result;
    }

    public static int noOfDigit(int num) {
        int digit = 0;
        while (num != 0) {
            digit++;
            num /= 10;
        }
        return digit;
    }

    public static void Fibonacci(int num) {
        if (num < 0) return;
        System.out.print("0 ");
        if (num == 0) return;
        System.out.print("1 ");
        int a = 0, b = 1;
        while (a + b <= num) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static int RevNum(int num) {
        int rev = 0;
        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static boolean Prime(int num) {
        int i = 2;
        while (i < num) {
            if (num % i == 0)
                return false;
            i++;
        }
        return true;
    }

    public static int GCD(int c, int d) {
        int l = Math.min(c, d);
        int gcd = 1, i = 2;
        while (i <= l) {
            if (c % i == 0 && d % i == 0)
                gcd = i;
            i++;
        }
        return gcd;
    }

    public static int LCM(int c, int d) {
        int l = Math.max(c, d);
        while (true) {
            if (l % c == 0 && l % d == 0)
                return l;
            l++;
        }
    }

    public static int SumDigit(int b) {
        int sum = 0;
        while (b != 0) {
            sum = sum + b % 10;
            b = b / 10;
        }
        return sum;
    }

    public static long Factorial(int a) {
        long fact = 1;
        for (int i = a; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }

    public static int Input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number : ");
        return input.nextInt();
    }
}
