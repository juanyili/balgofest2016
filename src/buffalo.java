import java.util.Scanner;

/**
 * Created by Wanyi and Elizabeth on 4/3/16.
 */
public class buffalo {

    public static String isRight(int x, int y, int[] d1, int [] pos) {
        boolean result = true;
        int a = d1[0];
        int b = d1[1];
        int c = pos[0] - x;
        int d = pos[1] - y;
        if (a*d - b*c > 0) {
            result = false;
        }
        if (result) {
            return "R";
        } else
            return "L";
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String nextLine = reader.nextLine();
            String[] line = nextLine.split(" ");
            int[] coordinates = new int[line.length];
            for (int i = 0; i < 8; i++) {
                coordinates[i] = Integer.parseInt(line[i]);
            }
            int[] pos = {coordinates[6], coordinates[7]};
            int[] dir12 = new int[2];
            dir12[0] = coordinates[2] - coordinates[0];
            dir12[1] = coordinates[3] - coordinates[1];
            String f1 = isRight(coordinates[0], coordinates[1], dir12, pos);
            int[] dir23 = new int[2];
            dir23[0] = coordinates[4] - coordinates[2];
            dir23[1] = coordinates[5] - coordinates[3];
            String f2 = isRight(coordinates[2], coordinates[3], dir23, pos);
            int[] dir31 = new int[2];
            dir31[0] = coordinates[0] - coordinates[4];
            dir31[1] = coordinates[1] - coordinates[5];
            String f3 = isRight(coordinates[4], coordinates[5], dir31, pos);

            String result = f1+f2+f3;
            System.out.println(result);
        }
    }
}
