/**
 *
 * Solution By: Amol Gade
 *
 * Note: for education purposes only
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

import java.util.ArrayList;


public class MinionsBoardGame {
    public static void main(String args[]) {
        int t = 6, n = 5;
        int recent = 0, last = 0;
        int result = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        for (int i = 2; i < n; i++) {
            list.add(0);
        }


        for (int j = 1; j < t; j++) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.print("\n");
            for (int i = 0; i < n; i++) {
                if (i == 0)
                    recent = list.get(i) % 123454321;
                else {
                    last = recent;
                    recent = list.get(i) % 123454321;
                }

                if (i == n - 2 || i == n - 1)
                    list.set(i, last + list.get(i) % 123454321);
                else if (i == 0)
                    list.set(i, list.get(i) % 123454321 + list.get(i + 1) % 123454321);
                else
                    list.set(i, last + list.get(i) % 123454321 + list.get(i + 1) % 123454321);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }

        result = list.get(n - 1) % 123454321;
        System.out.println("\nResult is " + list.get(n - 1) % 123454321);
        //return result;
    }
}