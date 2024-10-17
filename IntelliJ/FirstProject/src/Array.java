import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
//        int[] myArr = new int[5];
//        myArr[0] = 3;
//        myArr[1] = 5;
//        myArr[2] = 1;
//        myArr[3] = 4;
//        myArr[4] = 2;

//        int num = Input();
//        int[] myArr = {1, 2, 3, 4, 5};
//
//        boolean istext = false;
//        int i = 0;
//        while (i < 5) {
//            if (num == myArr[i]) {
//                istext = true;
//            }
//            i++;
//        }
//        if (istext)
//            System.out.println(num + " is found in array.");
//        else
//            System.out.println(num + " is not found in array.");

        String[] arr = new String[4];
        arr[0] = "Nazmul";
        arr[2] = "Hossain";

        String[] newStr = {"First", "Second", "Third"};
        System.out.println(arr.length);



//        for (i = 0; i < 5; i++) {
//            System.out.print(myArr[i] + " ");
//        }
//        System.out.println();
    }

    public static int Input() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number : ");
        return input.nextInt();
    }
}
