import java.awt.Point;
import java.util.*;

/**
 * Created by markdaniel on 3/28/16.
 */
public class CF320B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        List<Point> intervals = new ArrayList<>();
        intervals.add(new Point(0, 0));
        for (int i = 0; i < cases; i ++) {
            handleCase(intervals, scanner);
        }
    }

    public static void handleCase(List<Point> intervals, Scanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        boolean found = false;

        if (a == 1) {
            intervals.add(new Point(b, c));
        } else {
            bfs(b, c, found, intervals);
        }
    }

    public static void bfs(int b, int c,  boolean found, List<Point> intervals) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.push(b);

        Set<Integer> visited = new HashSet<>();
        while (!found && !queue.isEmpty()) {
            int head = queue.pop();
            found = head == c;

            for (int i = 0; i < intervals.size() && !found; i ++) {
                if (head != i && !visited.contains(i)) {
                    Point headPoint = intervals.get(head);
                    Point indexPoint = intervals.get(i);
                    boolean crosses = (headPoint.getX() > indexPoint.getX() && headPoint.getX() < indexPoint.getY())
                            || (headPoint.getY() < indexPoint.getY() && headPoint.getY() > indexPoint.getX());
                    if (crosses) {
                        queue.push(i);
                        visited.add(i);
                    }
                }
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
