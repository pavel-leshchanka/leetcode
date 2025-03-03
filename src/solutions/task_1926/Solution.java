package solutions.task_1926;

import java.util.LinkedList;

/**
 * 1926. Nearest Exit from Entrance in Maze
 * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls
 * (represented as '+'). You are also given the entrance of the maze, where entrance =
 * [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.
 * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall,
 * and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance.
 * An exit is defined as an empty cell that is at the border of the maze. The entrance does not count
 * as an exit.
 * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no
 * such path exists.
 */
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int high = maze.length;
        int length = maze[0].length;

        int startY = entrance[0];
        int startX = entrance[1];

        int moveLeft = startX - 1;
        int moveRight = startX + 1;
        int moveUp = startY - 1;
        int moveDown = startY + 1;

        maze[startY][startX] = '+';

        LinkedList<int[]> ints = new LinkedList<>();

        if (moveLeft >= 0 && moveLeft < length && maze[startY][moveLeft] == '.') {
            ints.add(new int[]{startY, moveLeft});
        }
        if (moveRight >= 0 && moveRight < length && maze[startY][moveRight] == '.') {
            ints.add(new int[]{startY, moveRight});
        }
        if (moveUp >= 0 && moveUp < high && maze[moveUp][startX] == '.') {
            ints.add(new int[]{moveUp, startX});
        }
        if (moveDown >= 0 && moveDown < high && maze[moveDown][startX] == '.') {
            ints.add(new int[]{moveDown, startX});
        }
        int step = 0;

        while (!ints.isEmpty()) {
            step++;
            int size = ints.size();

            for (int i = 0; i < size; i++) {
                int[] point = ints.pollFirst();

                int pointX = point[1];
                int pointY = point[0];
                if (pointX == 0 || pointX == length - 1 || pointY == 0 || pointY == high - 1) {
                    return step;
                }

                int moveL = pointX - 1;
                int moveR = pointX + 1;
                int moveU = pointY - 1;
                int moveD = pointY + 1;

                if (moveL >= 0 && maze[pointY][moveL] == '.') {
                    maze[pointY][moveL] = '+';
                    ints.add(new int[]{pointY, moveL});
                }
                if (moveR < length && maze[pointY][moveR] == '.') {
                    maze[pointY][moveR] = '+';
                    ints.add(new int[]{pointY, moveR});
                }
                if (moveU >= 0 && maze[moveU][pointX] == '.') {
                    maze[moveU][pointX] = '+';
                    ints.add(new int[]{moveU, pointX});
                }
                if (moveD < high && maze[moveD][pointX] == '.') {
                    maze[moveD][pointX] = '+';
                    ints.add(new int[]{moveD, pointX});
                }
            }
        }
        return -1;
    }
}