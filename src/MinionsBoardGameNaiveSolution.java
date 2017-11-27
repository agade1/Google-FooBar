/**
 *
 * Solution by : Amol Gade
 *
 * Note: for education purpose only
 *
 * Problem statement:
 * Minion's bored game
 ===================

 There you have it. Yet another pointless "bored" game created by the bored minions of Professor Boolean.

 The game is a single player game, played on a board with n squares in a horizontal row. The minion places a token on the left-most square and rolls a special three-sided die.

 If the die rolls a "Left", the minion moves the token to a square one space to the left of where it is currently. If there is no square to the left, the game is invalid, and you start again.

 If the die rolls a "Stay", the token stays where it is.

 If the die rolls a "Right", the minion moves the token to a square, one space to the right of where it is currently. If there is no square to the right, the game is invalid and you start again.

 The aim is to roll the dice exactly t times, and be at the rightmost square on the last roll. If you land on the rightmost square before t rolls are done then the only valid dice roll is to roll a "Stay". If you roll anything else, the game is invalid (i.e., you cannot move left or right from the rightmost square).

 To make it more interesting, the minions have leaderboards (one for each n,t pair) where each minion submits the game he just played: the sequence of dice rolls. If some minion has already submitted the exact same sequence, they cannot submit a new entry, so the entries in the leader-board correspond to unique games playable.

 Since the minions refresh the leaderboards frequently on their mobile devices, as an infiltrating hacker, you are interested in knowing the maximum possible size a leaderboard can have.

 Write a function answer(t, n), which given the number of dice rolls t, and the number of squares in the board n, returns the possible number of unique games modulo 123454321. i.e. if the total number is S, then return the remainder upon dividing S by 123454321, the remainder should be an integer between 0 and 123454320 (inclusive).

 n and t will be positive integers, no more than 1000. n will be at least 2.


 Languages
 =========

 To provide a Python solution, edit solution.py
 To provide a Java solution, edit solution.java

 Test cases
 ==========

 Inputs:
 (int) t = 1
 (int) n = 2
 Output:
 (int) 1

 Inputs:
 (int) t = 3
 (int) n = 2
 Output:
 (int) 3

 */

/**
 * This is a naive solution, for a time efficient solution check the other class named 'MinionsBoardGame'
 */

class MinionsBoardGameNaiveSolution {
    public static void main(String args[]) {
        int sum = 0, result = 0;
        int t = 6, n = 5;

        int first[][] = new int[n][n];
        int second[][] = new int[n][n];
        int multiply[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j < 2)
                    first[i][j] = 1;
                else if (i == j) {
                    first[i][j] = 1;
                    if (i == j && j < n - 1) {
                        first[i][j - 1] = 1;
                        first[i][j + 1] = 1;
                    }
                } else if (first[i][j] == 0) {
                    first[i][j] = 0;
                }
            }
        }

        System.out.println("First matrix:-");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(first[i][j] + "\t");

            System.out.print("\n");
        }

        if (t == 1) {
            result = (first[0][n - 1] % 123454321);
            System.out.print("\ntotal number of possible paths = " + result);
        } else {

            for (int iter = 1; iter < t; iter++) {
                if (iter == 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < n; k++) {
                                sum = sum + first[i][k] * first[k][j];
                            }

                            multiply[i][j] = sum;
                            sum = 0;
                        }
                    }
                } else {

                    for (int i = 0; i < n; i++)
                        for (int j = 0; j < n; j++)
                            second[i][j] = multiply[i][j];

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            for (int k = 0; k < n; k++) {
                                sum = sum + first[i][k] * second[k][j];
                            }

                            multiply[i][j] = sum;
                            sum = 0;
                        }
                    }
                }
            }

            System.out.println("Product of entered matrices:-");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(multiply[i][j] + "\t");

                System.out.print("\n");
            }

            result = (multiply[0][n - 1] % 123454321);
            System.out.print("\ntotal number of possible paths = " + result);
        }
        //return result;
    }
}