package solutions.task_2336;

import java.util.TreeSet;

/**
 * 2336. Smallest Number in Infinite Set
 * You have a set which contains all positive integers [1, 2, 3, 4, 5, ...].
 * Implement the SmallestInfiniteSet class:
 * SmallestInfiniteSet() Initializes the SmallestInfiniteSet object to contain all positive
 * integers.
 * int popSmallest() Removes and returns the smallest integer contained in the infinite set.
 * void addBack(int num) Adds a positive integer num back into the infinite set, if it is not
 * already in the infinite set.
 */
class SmallestInfiniteSet {

    private final TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        this.set = new TreeSet<>();
        for (int i = 1; i < 1001; i++) {
            set.add(i);
        }
    }

    public int popSmallest() {
        Integer first = set.first();
        set.remove(first);
        return first;
    }

    public void addBack(int num) {
        set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
