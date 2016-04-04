import java.util.Scanner;

/**
 * Created by Elizabeth and Wanyi on 4/3/16.
 */
public class fibonacci {
    public static int fibonacci (int n) {
        if (n == 0) {
            return 0;
        } else {

            return fibonacci_helper(n, 1, 0, 1);
        }
    }
    public static int fibonacci_helper(int n, int curr, int fib_curr_minus_1, int fib_curr) {
        System.out.format("fibonacci_helper(%d,%d,%d,%d)", n, curr, fib_curr_minus_1, fib_curr);
        System.out.println();
        if (n == curr) {
            int result = fib_curr;
            for (int i = 0; i < n; i++) {
                System.out.format("fibonacci_helper=%d",result);
                System.out.println();
            }
            return result;
        } else {
            return fibonacci_helper(n, curr+1, fib_curr, fib_curr+fib_curr_minus_1);
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try {
            while (reader.hasNextLine()) {
                int n = Integer.parseInt(reader.nextLine());
                System.out.println(n);
                System.out.format("fibonacci(%d)", n);
                System.out.println();
                int result = fibonacci(n);
                System.out.format("fibonacci=%d",result);
                System.out.println();
            }
        } catch (NumberFormatException e) {

        }

    }
}
