import java.util.Scanner;

/**
 * Created by markdaniel on 1/29/16.
 */
public class CF505A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextLine()) {
            System.out.println(doKitayuta(scanner.nextLine()));
        }
    }

    public static String doKitayuta(String word) {
        int wordLen = word.length();
        StringBuilder sb = new StringBuilder();
        if (wordLen == 1) {
            return sb.append(word + word).toString();
        }
        if (wordLen == 2) {
            if (word.charAt(0) == word.charAt(1)) {
                return sb.append("" + word.charAt(0) + 'x' + word.charAt(1)).toString();
            } else {
                return sb.append(word.charAt(1) + word).toString();
            }
        }

        int start = 0;
        int end = wordLen - 1;

        word = recurse(word, start, end, false);

        return word;
    }

    public static String recurse(String word, int start, int end, boolean affixed) {
        int wordLen = word.length();
        StringBuilder sb = new StringBuilder();
        char startChar = word.charAt(start);
        char endChar = word.charAt(end);

        if ((end - start) <= 1) {
            if (end == start && !affixed) {
                word = sb.append(word.substring(0, start + 1) + word.charAt(start) + word.substring(start + 1, wordLen)).toString();
            } else if (!affixed) {
                // Means that it is even so must add a random digit in middle
                word = sb.append(word.substring(0, start + 1) + "x" + word.substring(start + 1, wordLen)).toString();
            } else if (affixed && (end - start == 1) && startChar != endChar) {
                return "NA";
            }

            return word;
        }

        if (affixed && startChar != endChar) {
            return "NA";
        }

        String result = "NA";

        if (startChar == endChar) {
            result = recurse(word, start + 1, end - 1, affixed);
        }

        if (!affixed && (result.equals("NA") || word.equals(result)) && startChar == word.charAt(end - 1)) {
            result = recurse(word.substring(0, start) + endChar + word.substring(start, wordLen),
                    start + 1, end, true);
        }

        if (!affixed && (result.equals("NA") || word.equals(result)) && word.charAt(start + 1) == endChar) {
            result = recurse(word.substring(0, end + 1) + startChar + word.substring(end + 1, wordLen),
                    start + 1, end, true);
        }

        return result;
    }
}
