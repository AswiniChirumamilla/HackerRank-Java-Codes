Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:

Move Backward: If cell  exists and contains a , you can walk back to cell .
Move Forward:
If cell  contains a zero, you can walk to cell .
If cell  contains a zero, you can jump to cell .
If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.
Function Description

Complete the canWin function in the editor below.

canWin has the following parameters:

int leap: the size of the leap
int game[n]: the array to traverse
Returns

boolean: true if the game can be won, otherwise false
Input Format

The first line contains an integer, , denoting the number of queries (i.e., function calls).
The  subsequent lines describe each query over two lines:

The first line contains two space-separated integers describing the respective values of  and .
The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
Constraints

It is guaranteed that the value of  is always .
Sample Input

STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0
Sample Output

YES
YES
NO
NO
Explanation

We perform the following  queries:

For  and , we can walk and/or jump to the end of the array because every cell contains a . Because we can win, we return true.
For  and , we can walk to index  and then jump  units to the end of the array. Because we can win, we return true.
For  and , there is no way for us to get past the three consecutive ones. Because we cannot win, we return false.
For  and , there is no way for us to get past the one at index . Because we cannot win, we return false.





#######################################    CODE ##########################3333
import java.util.Scanner;

/**
 * Created by nikoo28 on 7/5/17.
 */
public class TwoCharacters {

  public static final int NUM_LETTERS = 26;

  public static void main(String[] args) {

    /* Save input */
    Scanner scan = new Scanner(System.in);
    int length = scan.nextInt();
    String str = scan.next();
    scan.close();

    /* Edge case */
    if (length <= 1) {
      System.out.println(0);
      return;
    }

    /* Create arrays representing the 26^2 subproblems */
    int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
    int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

    for (int i = 0; i < length; i++) {
      char letter = str.charAt(i);
      int letterNum = letter - 'a';

      /* Update row */
      for (int col = 0; col < NUM_LETTERS; col++) {
        if (pair[letterNum][col] == letter) {
          count[letterNum][col] = -1;
        }
        if (count[letterNum][col] != -1) {
          pair[letterNum][col] = letter;
          count[letterNum][col]++;
        }
      }

      /* Update column */
      for (int row = 0; row < NUM_LETTERS; row++) {
        if (pair[row][letterNum] == letter) {
          count[row][letterNum] = -1;
        }
        if (count[row][letterNum] != -1) {
          pair[row][letterNum] = letter;
          count[row][letterNum]++;
        }
      }
    }

    /* Find max in "count" array */
    int max = 0;
    for (int row = 0; row < NUM_LETTERS; row++) {
      for (int col = 0; col < NUM_LETTERS; col++) {
        max = Math.max(max, count[row][col]);
      }
    }
    System.out.println(max);
  }

}
Code language: Java (java)
