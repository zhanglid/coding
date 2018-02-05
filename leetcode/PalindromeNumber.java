/*
Determine whether an integer is a palindrome. Do this without extra space.

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

/*
*   Soulution: 1. 反转整数，之后比较是否相等。存在overflow
               2. 依次头尾进行比较
*   Corner case: -2147447412 => false, true!: 负数一定不是palindrome?
*                overflow: 直接反转integer存在overflow问题，
*   Complexity: time: O(1), space: O(1)
*/
class PalindromeNumber {
    /*
    // This one has some overflow issue. 2147483647 => 7463847421
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int base = 1;
        int t = x;
        while (t >= 10) {
            base *= 10;
            t /= 10;
        }
        t = x;
        int y = 0;
        while (t > 0) {
            y += base * (t % 10);
            base /= 10;
            t /= 10;
        }
        // System.out.println(y);
        return y == x;
    }*/
    
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int base = 1;
        int t = x;
        while (t >= 10) {
            base *= 10;
            t /= 10;
        }
        t = x;
        while (t != 0) {
            if (t / base != t % 10) {
                return false;
            }
            t %= base;
            t = t / 10;
            base /= 100;
        }
        
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber s = new PalindromeNumber();
        System.out.println(s.isPalindrome(1221));
    }
}