/**
 * Solution by : Amol Gade
 * <p>
 * Note: for education purpose only
 * <p>
 * Problem statement not available
 */

public class RustyCalculator {
    public static void main(String[] args) {

        String Input = "2*4*3+9*3+5";
        String Output = "", Numbers = "", multi = "", add = "";
        String[] temp;
        temp = Input.split("");
        if (temp.length > 100) {
            System.out.println("Invalid Input");
            return;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("*")) {
                multi += temp[i];
            } else if (temp[i].compareTo("+") == 0) {
                Output += Numbers + multi;
                Numbers = "";
                multi = "";
                add += temp[i];
            } else
                Numbers += temp[i];
        }
        Output += Numbers + multi + add;
        System.out.println("Output =>  " + Output);
        //System.out.println("Output =>  "+multi);

    }

}
