import java.awt.*;
import java.util.Scanner;

/**
 * Created by markdaniel on 2/16/16.
 */
public class CF448C {

    private static int[] FENCE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String posts = sc.nextLine();
        String [] fenceStrings = posts.split(" ");
        FENCE= new int[fenceStrings.length];
        for (int i = 0; i < fenceStrings.length; i ++) {
            FENCE[i] = Integer.parseInt(fenceStrings[i]);
        }

        System.out.println(divideConquer(0, FENCE.length, 0));
    }

    public static int divideConquer(int start, int end, int floor) {
        if (start >= end) {
            return 0;
        }

        Point minA = new Point(0, Integer.MAX_VALUE);
        Point minB = new Point();
        Point minC = new Point();

        boolean notPeaked = true;
        int prev = -1;

        int strokes = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i ++) {
            int h = FENCE[i] - floor;

            if (notPeaked && h < prev) {
                notPeaked = false;
            } else if (notPeaked){
                minA.setLocation(i, h);
            }


            if (h < min) {
                min = h;
            }

            prev = h;
        }

        if (minA.y < min) {
            min = minA.y;
        }

        if ((end - start) <= min) {
            return (end - start);
        }

        strokes += min;

        int newStart = 0;
        boolean didExceedMin = false;
        boolean endNotMin = false;
        for (int i = start; i < end; i ++) {
            if (FENCE[i] == (min + floor)) {
                strokes += divideConquer(newStart, i, (min + floor));
                newStart = i + 1;
                didExceedMin = false;
            } else if (i == (end - 1)) {
                endNotMin = true;
            } else {
                didExceedMin = true;
            }
        }

        if (endNotMin && didExceedMin) {
            strokes += divideConquer(newStart, end, (min + floor));
        }

        return strokes;
    }
}
