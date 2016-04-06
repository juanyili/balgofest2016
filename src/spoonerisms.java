
import java.util.HashSet;
import java.util.Scanner;


/**
 * Created by Wanyi and Elizabeth on 4/3/16.
 */
public class spoonerisms {

    public static void main(String [] args) {
        Scanner reader = new Scanner(System.in);


        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] words = line.split(" ");
            String firstWord = words[0];
            char[] chars = firstWord.toCharArray();
            char firstChar = chars[0];
            String lastWord = words[words.length - 1];
            char[] last_chars = lastWord.toCharArray();
            char lastChar = last_chars[0];
            HashSet<Character> vowels = new HashSet<>();
            vowels.add('a');
            vowels.add('e');
            vowels.add('i');
            vowels.add('o');
            vowels.add('u');
            String temp_last = "";
            String temp_first = "";
            StringBuilder sb_first = new StringBuilder();
            char curr_char = firstChar;
            int n = 1;
            while (n < chars.length && !vowels.contains(curr_char)) {
                sb_first.append(curr_char);
                curr_char = chars[n];
                n++;
                vowels.add('y');
            }

            StringBuilder sb = new StringBuilder();
            char curr_last_char = lastChar;
            int i = 1;
            vowels.remove('y');
            while (i < last_chars.length && !vowels.contains(curr_last_char)) {
                sb.append(curr_last_char);
                curr_last_char = last_chars[i];
                i++;
                vowels.add('y');
            }
            vowels.remove('y');

            if (!vowels.contains(firstChar)) {
                if (!vowels.contains(lastChar)) {

                    temp_first = sb.toString() + firstWord.substring(sb_first.length());
                    temp_last = sb_first.toString() + lastWord.substring(sb.length());
                } else {
                    temp_first = firstWord.substring(sb_first.length());
                    temp_last = sb_first.toString() + lastWord;
                }
            } else {
                if (!vowels.contains(lastChar)) {

                    temp_first = sb.toString() + firstWord;
                    temp_last = lastWord.substring(sb.length());
                }
            }


            if (!temp_last.isEmpty()) {
                lastWord = temp_last;
            }
            if (!temp_first.isEmpty()) {
                firstWord = temp_first;
            }
            String new_line = firstWord;
            for (int j = 1; j < words.length - 1; j++) {
                new_line += " " + words[j];
            }
            new_line += " " + lastWord;
            System.out.println(new_line);
        }
    }

}
