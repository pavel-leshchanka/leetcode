package solutions.task_1105;

/**
 * 1105. Filling Bookcase Shelves
 * You are given an array books where books[i] = [thicknessi, heighti] indicates the thickness and height of the ith book. You are also given an integer shelfWidth.
 * We want to place these books in order onto bookcase shelves that have a total width shelfWidth.
 * We choose some of the books to place on this shelf such that the sum of their thickness is less than or equal to shelfWidth, then build another level of the shelf of the bookcase so that the total height of the bookcase has increased by the maximum height of the books we just put down. We repeat this process until there are no more books to place.
 * Note that at each step of the above process, the order of the books we place is the same order as the given sequence of books.
 * For example, if we have an ordered list of 5 books, we might place the first and second book onto the first shelf, the third book on the second shelf, and the fourth and fifth book on the last shelf.
 * Return the minimum possible height that the total bookshelf can be after placing shelves in this manner.
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        for (int i = 1; i <= books.length; i++) {
            dp[i] = dp[i - 1] + books[i - 1][1];
            int height = books[i - 1][1];
            int width = books[i - 1][0];
            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelfWidth; j--) {
                height = Math.max(height, books[j - 1][1]);
                width += books[j - 1][0];
                dp[i] = Math.min(dp[i], height + dp[j - 1]);
            }

        }
        return dp[books.length];
    }
}