package solutions.task_735;

import java.util.LinkedList;

/**
 * 735. Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row.
 * The indices of the asteriod in the array represent their relative position in space.
 * For each asteroid, the absolute value represents its size, and the sign represents its
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet,
 * the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroidRight = asteroids[i];
            extracted(integers, asteroidRight);
        }
        return integers.stream().mapToInt(e -> (int) e).toArray();
    }

    private static void extracted(LinkedList<Integer> integers, int asteroidRight) {
        if (integers.isEmpty()) {
            integers.add(asteroidRight);
        } else {
            while (!integers.isEmpty()) {
                int asteroidLeft = integers.pollLast();
                if (asteroidLeft < 0 && asteroidRight < 0) {
                    integers.add(asteroidLeft);
                    integers.add(asteroidRight);
                    break;
                } else if (asteroidLeft > 0 && asteroidRight > 0) {
                    integers.add(asteroidLeft);
                    integers.add(asteroidRight);
                    break;
                } else if (asteroidLeft < 0 && asteroidRight > 0) {
                    integers.add(asteroidLeft);
                    integers.add(asteroidRight);
                    break;
                }
                if (asteroidLeft > 0 && asteroidRight < 0) {
                    if (asteroidLeft + asteroidRight != 0) {
                        if (Math.abs(asteroidLeft) > Math.abs(asteroidRight)) {
                            integers.add(asteroidLeft);
                            break;
                        } else {
                            extracted(integers, asteroidRight);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}