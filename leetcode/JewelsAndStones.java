import java.util.HashSet;
import java.util.Set;

/*

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
Note:

S and J will consist of letters and have length at most 50.
The characters in J are distinct.

*/

/*
*  Solution: HashSet
*
*  Corner Case: 
*
*  Complexity: time: o(n), space: o(J.length)
*/

class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() < 1 || S == null || S.length() < 1) {
            return 0;
        }
        int ans = 0;        
        Set<Character> set = new HashSet<>();
        for (char x: J.toCharArray()) {
            set.add(x);
        }
        for (char x : S.toCharArray()) {
            if (set.contains(x)) {
                ans++;
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        JewelsAndStones s = new JewelsAndStones();
        System.out.println(s.numJewelsInStones("zA", "AZZZ"));
    }
}