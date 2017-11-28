import java.util.ArrayList;
import java.util.Collections;

/**
 * * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement:
 * When it rains it pours
 * ======================
 * <p>
 * It's raining, it's pouring. You and your agents are nearing the building where the captive rabbits are being held, but a sudden storm puts your escape plans at risk. The structural integrity of the rabbit hutches you've built to house the fugitive rabbits is at risk because they can buckle when wet. Before the rabbits can be rescued from Professor Boolean's lab, you must compute how much standing water has accumulated on the rabbit hutches.
 * <p>
 * Specifically, suppose there is a line of hutches, stacked to various heights and water is poured from the top (and allowed to run off the sides). We'll assume all the hutches are square, have side length 1, and for the purposes of this problem we'll pretend that the hutch arrangement is two-dimensional.
 * <p>
 * For example, suppose the heights of the stacked hutches are [1,4,2,5,1,2,3] (the hutches are shown below):
 * <p>
 * ...X...
 * .X.X...
 * .X.X..X
 * .XXX.XX
 * XXXXXXX
 * 1425123
 * <p>
 * When water is poured over the top at all places and allowed to runoff, it will remain trapped at the 'O' locations:
 * <p>
 * ...X...
 * .XOX...
 * .XOXOOX
 * .XXXOXX
 * XXXXXXX
 * 1425123
 * <p>
 * The amount of water that has accumulated is the number of Os, which, in this instance, is 5.
 * <p>
 * Write a function called answer(heights) which, given the heights of the stacked hutches from left-to-right as a list, computes the total area of standing water accumulated when water is poured from the top and allowed to run off the sides.
 * <p>
 * The heights array will have at least 1 element and at most 9000 elements. Each element will have a value of at least 1, and at most 100000.
 * <p>
 * Test cases
 * ==========
 * <p>
 * Inputs:
 * (int list) heights = [1, 4, 2, 5, 1, 2, 3]
 * Output:
 * (int) 5
 * <p>
 * Inputs:
 * (int list) heights = [1, 2, 3, 2, 1]
 * Output:
 * (int) 0
 */

public class WhenItRainsItPours {

    public static void main(String agrs[]) {

        //input
        Integer[] heights = {3, 2, 3, 2, 1, 2, 2, 2, 7, 4, 9, 5, 1, 10, 4, 8, 5, 6, 7, 8, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

        int total = 0, maxno1, maxno2, index1, index2, listindex;
        ArrayList<Integer> heightsList = new ArrayList<Integer>();
        ArrayList<Integer> TempList = new ArrayList<Integer>();

        for (int i1 = 0; i1 < heights.length; i1++) {
            heightsList.add(heights[i1]);
            TempList.add(heights[i1]);
        }
        Collections.sort(heightsList, Collections.reverseOrder());


        //for(int i3 = 1;i3<heightsList.size();i3++)
        while (heightsList.size() > 1) {
            System.out.println("height list size=======" + heightsList.size());

            System.out.print("\n");
            maxno1 = heightsList.get(0);
            index1 = TempList.indexOf(maxno1);
            maxno2 = heightsList.get(1);
            index2 = TempList.indexOf(maxno2);
            System.out.print("\n");
            for (int i4 = 0; i4 < TempList.size(); i4++) {
                System.out.print(" " + TempList.get(i4));
            }
            System.out.print("\n");
            for (int i4 = 0; i4 < TempList.size(); i4++) {
                System.out.print(" " + heightsList.get(i4));
            }
            System.out.println("\nmax no1==" + maxno1 + " index1--" + index1);
            System.out.println("max no2==" + maxno2 + " index2--" + index2);
            if (index1 > index2) {
                int temp = 0;
                for (int i7 = 0; i7 < index1 - index2; i7++) {
                    temp = TempList.get(index2);
                    total += (maxno2 - temp);
                    System.out.println("\n" + maxno2 + temp);
                    System.out.println("\ntotal====" + total);
                    System.out.print("removed " + temp);
                    listindex = heightsList.indexOf(temp);
                    heightsList.remove(listindex);
                    TempList.remove(index2);
                }

            }

            if (index1 < index2) {
                int temp = 0;
                for (int i8 = 0; i8 < index2 - index1; i8++) {
                    temp = TempList.get(index1 + 1);
                    total += (maxno2 - temp);
                    System.out.println("" + maxno2 + temp);
                    System.out.println("\ntotal====" + total);
                    System.out.print("removed " + temp);
                    listindex = heightsList.indexOf(temp);
                    heightsList.remove(listindex);
                    TempList.remove(index1 + 1);
                }

            }
        }
        System.out.println("\ntotal====" + total);
        //return total;
    }
}
