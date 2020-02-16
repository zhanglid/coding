package com.zhangliang.leetcode;
/*
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
*/

import java.util.*;

public class DesignSnakeGame {
    static class SnakeGame {
        private static final Map<String, int[]> DIRS;
        static {
            DIRS = new HashMap<>();
            DIRS.put("U", new int[] { -1, 0 });
            DIRS.put("D", new int[] { 1, 0 });
            DIRS.put("L", new int[] { 0, -1 });
            DIRS.put("R", new int[] { 0, 1 });
        }

        Queue<int[]> foods = new LinkedList<>();
        LinkedList<int[]> snake = new LinkedList<>();
        Set<Integer> snakeSet = new HashSet<>();
        int width;
        int height;

        private int getHash(int[] point) {
            return point[0] * width + point[1];
        }

        /**
         * Initialize your data structure here.
         * 
         * @param width  - screen width
         * @param height - screen height
         * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the
         *               first food is positioned at [1,1], the second is at [1,0].
         */
        public SnakeGame(int width, int height, int[][] food) {
            this.width = width;
            this.height = height;
            for (int[] item : food) {
                foods.add(item);
            }
            int[] head = new int[] { 0, 0 };
            snake.add(head);
            snakeSet.add(getHash(head));
        }

        /**
         * Moves the snake.
         * 
         * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         * @return The game's score after the move. Return -1 if game over. Game over
         *         when snake crosses the screen boundary or bites its body.
         */
        public int move(String direction) {
            int[] nextHead = new int[] { snake.peekFirst()[0] + DIRS.get(direction)[0],
                    snake.peekFirst()[1] + DIRS.get(direction)[1] };
            int[] food = foods.isEmpty() ? null : foods.peek();
            int hash = getHash(nextHead);
            if (nextHead[0] < 0 || nextHead[0] >= height || nextHead[1] < 0 || nextHead[1] >= width) {
                return -1;
            }
            if (food == null || food[0] != nextHead[0] || food[1] != nextHead[1]) {
                int[] tail = snake.pollLast();
                int tailHash = getHash(tail);
                snakeSet.remove(tailHash);
            } else {
                foods.poll();
            }
            if (snakeSet.contains(hash)) {
                return -1;
            }
            snakeSet.add(hash);
            snake.addFirst(nextHead);
            return snake.size() - 1;
        }
    }
}
