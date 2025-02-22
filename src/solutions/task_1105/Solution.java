package solutions.task_1105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

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
        List<List<Integer>> list1 = Arrays.stream(books)
            .map(s -> Arrays.stream(s)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new)))
            .sorted((p1, p2) -> {
                if (!p1.get(1).equals(p2.get(1))) {
                    return p2.get(1).compareTo(p1.get(1));
                } else {
                    return p2.getFirst().compareTo(p1.getFirst());
                }
            }).collect(toCollection(ArrayList::new));
        int high = 0;
        int width = 0;
        while (!list1.isEmpty()) {
            high += list1.getFirst().get(1);
            width += list1.getFirst().get(0);
            list1.removeFirst();
            ArrayList<List<Integer>> lists = new ArrayList<>(list1);
            for (List<Integer> list : lists) {
                if (width + list.get(0) <= shelfWidth) {
                    width += list.get(0);
                    list1.remove(list);
                }
                if (width == shelfWidth) break;
            }
            width = 0;
        }
        return high;
    }
}