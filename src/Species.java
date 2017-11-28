import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement not available
 */

public class Species {
    public static void main(String[] args) {

        //(int) intervals = [[19, 20], [19, 20], [1, 3],[22,25],[45,50]]
        // 1-2,6-7,11-12,16-17,21-22
        int[][] intervals = new int[][]{{10, 14}, {4, 18}, {19, 20}, {19, 20}, {18, 21}, {1, 3}, {45, 50}, {20, 25}};
        ArrayList<Integer> input = new ArrayList<Integer>(intervals.length);
        ArrayList<Integer> output = new ArrayList<Integer>(intervals.length);
        int result = 0;
        // System.out.println();
        for (int i = 0; i < intervals.length; i++) {
            input.add(intervals[i][0]);
            output.add(intervals[i][1]);
        }
        Collections.sort(input);
        Collections.sort(output);
        int in = input.get(0), out;
        for (int i = 0; i < intervals.length; i++) {
            if (i < intervals.length - 1) {
                if (input.get(i + 1) > output.get(i)) {
                    result += output.get(i) - in;
                    System.out.println("in" + in + "out" + output.get(i));
                    in = input.get(i + 1);
                }
            } else {
                result += output.get(i) - in;
                System.out.println("in" + in + "out" + output.get(i));
            }
        }
        System.out.println("result " + result);
    }
}

