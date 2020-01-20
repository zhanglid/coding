package com.zhangliang.leetcode;
/*
Design a data structure that supports all following operations in 
average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. 
The probability of each element being returned is linearly related to 
the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not 
contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection
 contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains 
[1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 
with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains 
[1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/

import java.util.*;

public class InsertDeleteGetrandomO1DuplicatesAllowed {
    static class RandomizedCollection {

        List<Integer> values = new ArrayList<>();
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedCollection() {
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not
         * already contain the specified element.
         */
        public boolean insert(int val) {
            boolean has = indexMap.containsKey(val);
            if (!has) {
                indexMap.put(val, new HashSet<>());
            }
            values.add(val);
            indexMap.get(val).add(values.size() - 1);
            return has;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained
         * the specified element.
         */
        public boolean remove(int val) {
            boolean has = indexMap.containsKey(val);
            if (has) {
                int index = indexMap.get(val).iterator().next();
                indexMap.get(val).remove(index);
                if (indexMap.get(val).isEmpty()) {
                    indexMap.remove(val);
                }

                if (index != values.size() - 1) {
                    int last = values.get(values.size() - 1);
                    indexMap.get(last).remove(values.size() - 1);
                    indexMap.get(last).add(index);
                    values.set(index, last);
                }
                values.remove(values.size() - 1);

            }
            return has;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return values.get(rand.nextInt(values.size()));
        }
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
     * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
     * obj.getRandom();
     */
}
