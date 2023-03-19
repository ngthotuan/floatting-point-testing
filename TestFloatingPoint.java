import java.util.Scanner;

/**
 * Created by tuannt7 on 19/03/2023
 */
public class TestFloatingPoint {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        long number = new Scanner(System.in).nextLong();
        System.out.printf("d: %d\n" , number);
        System.out.printf("float: %.1f\n" , (float)number);
        System.out.printf("double: %.1f\n" , (double)number);
        System.out.println("d == float: " + (number == (long)(float)number));
        System.out.println("d == double: " + (number == (long)(double)number));
    }
}
