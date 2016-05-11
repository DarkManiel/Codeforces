import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by markdaniel on 1/24/16.
 */
public class CF405A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCols = scanner.nextInt();
        scanner.nextLine();

        int[] colVals = new int[numCols];
        for (int i = 0; i < numCols; i ++) {
            colVals[i] = scanner.nextInt();
        }

        doGravityFlip(numCols, colVals);
    }

    public static void doGravityFlip(int numCols, int[] colVals) {
        List<Integer> flipped = new ArrayList<Integer>();
        int[] finalColVals = new int[numCols];

        for (int i : colVals) {
            for (int j = 0; j < i; j ++) {
                if (j >= flipped.size()) {
                    flipped.add(1);
                    finalColVals[numCols - 1] ++;
                } else {
                    flipped.set(j, flipped.get(j) + 1);
                    finalColVals[numCols - (flipped.get(j))] ++;
                }
            }
        }

        for (int i = 0; i < numCols; i ++) {
            if (i != 0) { System.out.print(" "); }
            System.out.print(finalColVals[i]);
        }
    }
}
