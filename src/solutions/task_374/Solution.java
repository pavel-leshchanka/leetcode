package solutions.task_374;

/**
 * 374. Guess Number Higher or Lower
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class Solution /*extends GuessGame*/ {
    public int guessNumber(int n) {
        int priv = 0;
        int number = n;
        int i = guess(number);
        while (i != 0) {
            int temp = number;
            int i1 = Math.abs(number - priv);
            if (i == 1) {
                if (i1 == 1) i1 = 2;
                number = number + i1 / 2;
            } else {
                if (i1 == 1) i1 = 2;
                number = number - i1 / 2;
            }
            priv = temp;
            i = guess(number);
        }
        return number;
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public int guess(int num) {
        return -1;
    }
}