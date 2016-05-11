import java.util.Scanner;

/**
 * Created by markdaniel on 3/10/16.
 */
public class CF407B {
    private static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numRooms = sc.nextInt();
        sc.nextLine();

        int [] rooms = new int[numRooms];

        String [] input = sc.nextLine().split(" ");
        for (int i = 0; i < numRooms; i++) {
            rooms[i] = Integer.parseInt(input[i]);
        }

        long[] curCache = new long[numRooms];
        long[] sumCache = new long[numRooms];
        sumCache[0] = 2;
        curCache[0] = 2;
        for (int i = 1; i < numRooms; i ++) {
            int adjustedRoom = rooms[i] - 1;
            if (adjustedRoom == i) {
                curCache[i] = 2;
            } else {
                curCache[i] = (2 + ((curCache[adjustedRoom]) + Math.max(((sumCache[i - 1] ) - (sumCache[adjustedRoom] )), 0)  ) ) % mod;
            }
            sumCache[i] = ((curCache[i])  + (sumCache[i - 1]) ) ;
        }

        System.out.println(sumCache[numRooms - 1] % mod);
    }
}
