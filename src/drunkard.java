import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Elizabeth and Wanyi on 4/3/16.
 */
public class drunkard {
    /**
     * assuming first random number is seed
     * @param m
     * @param s
     */
    public static void W (int m, long s) {

        int p = 0;
        for (int i = 0; i < 35 + p; i++) {
            System.out.print(" ");
        }
        System.out.println("*");

        for (int j = 0; j < m; j++) {
            if (s % 2 == 1) {
                p += 1;

            } else {
                p -= 1;
            }
            for (int i = 0; i < 35 + p; i++) {
                System.out.print(" ");
            }
            System.out.println("*");
            s = (s * 16807) % 2147483647;

        }
    }

    public static void H (int m, int n, long s) {
        HashMap<Integer,Integer> countdict = new HashMap<>();
        for (int i = -m; i <= m; i+=2) {
            countdict.put(i, 0);
        }
        for (int j = 0; j < n; j++) {
            int p = 0;

            for (int k = 0; k < m; k++) {
                if (s % 2 == 1) {
                    p += 1;
                } else {
                    p -= 1;
                }
                s = (s * 16807) % 2147483647;
            }
            int val = countdict.get(p)+1;
            countdict.put(p, val);

        }
//        HashMap<Integer, Double> probdict = new HashMap<>();
        for (int k = -m; k <= m; k+=2) {
            double npm = Math.exp(-(Math.pow(k,2)/(2*m)))/Math.sqrt(2 * Math.PI * m);
            double prob = 2 * n * npm;
//            probdict.put(k, prob);
            System.out.printf("%15d%15d%15.1f\n",k,countdict.get(k),prob);
        }
    }

    public static void main(String [] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            String[] line = nextLine.split(" ");
            if (line[0].equals("W")) {
                System.out.println(nextLine);
                W(Integer.parseInt(line[1]), Long.parseLong(line[2]));
            }
            if (line[0].equals("H")) {
                System.out.println(nextLine);
                H(Integer.parseInt(line[1]), Integer.parseInt(line[2]), Long.parseLong(line[3]));
            }
        }
    }

    }
