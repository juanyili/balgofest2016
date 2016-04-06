import java.util.Scanner;

/**
 * Created by Wanyi and Elizabeth on 4/3/16.
 */
public class fractions {

    public static void f(double x) {

        boolean r = false;
        for (double d = 1; d < 1001; d++) {
            for (double n = 1; n < 1001; n++) {

                if ((x-n/d < 0.5e-9 && x-n/d > 0)|| (x-n/d > -0.5e-9 && x-n/d<0)) {
                    r = true;
                    Double y = x;
                    String z = String.format("%.15f",x);
//                    System.out.printf("%.15f %d/%d\n",x, n, d);
                    System.out.println(z + " " + (int)n + "/" + (int)d);
                    return;
                }
            }

        }
        if (!r) {
            System.out.printf("%.15f -\n",x);
        }
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String x = reader.nextLine();
            f(Double.parseDouble(x));
        }
    }
}
