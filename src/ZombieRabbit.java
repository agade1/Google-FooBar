import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement not available
 */
public class ZombieRabbit {

    public static void main(String[] args) {

        int[][] meetings = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 5}, {4, 5}, {1, 3}, {7, 8}};
        ArrayList<Integer> start = new ArrayList<Integer>(meetings.length);
        ArrayList<Integer> end = new ArrayList<Integer>(meetings.length);
        int total = 0, Range_end = 0, min_end, min_start, index;
        for (int i = 0; i < meetings.length; i++) {
            start.add(meetings[i][0]);
            end.add(meetings[i][1]);
        }
        for (int i = meetings.length; i > 0; i--) {
            min_end = Collections.min(end);
            index = end.indexOf(min_end);
            min_start = start.get(index);
            if (min_start >= Range_end) {
                Range_end = min_end;
                total += 1;
                System.out.println("min_end " + min_end + "\nindex " + index + "\nmin_start " + min_start + "\n");
            }
            start.remove(index);
            end.remove(index);
        }
        System.out.print("total===>" + total);
        // return total;
    }
}

