/*
In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

Example:

Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
Output: True
Explanation:
We can transform start to end following these steps:
RXXLRXRXL ->
XRXLRXRXL ->
XRLXRXRXL ->
XRLXXRRXL ->
XRLXXRRLX
Note:

1 <= len(start) = len(end) <= 10000.
Both start and end will only consist of characters in {'L', 'R', 'X'}.
*/

/*
*  Solution: 双指针，从头开始扫描到第一个非X字符，然后对比。L：向左，R：向右。
*
*  Corner Case: 
*
*  Complexity: o(n)
*/
class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null || start.length() < 1 || end.length() < 1 || start.length() != end.length()) {
            return false;
        }
        
        int i = 0;
        int j = 0;
        char[] schars = start.toCharArray();
        char[] echars = end.toCharArray(); 
        while (i < schars.length && j < echars.length) {
            while (i < schars.length && schars[i] == 'X') {
                i++;
            }
            
            while (j < echars.length && echars[j] == 'X') {
                j++;
            }
            
            if (i >= schars.length || j >= echars.length) {
                break;
            }
            if (schars[i] != echars[j] || schars[i] == 'L' && j > i || schars[i] == 'R' && j < i) {
                return false;
            }
            
            i++;
            j++;
        }
        
        // 
        while (i < schars.length && schars[i] == 'X') {
            i++;
        }
            
        while (j < echars.length && echars[j] == 'X') {
            j++;
        }
        // System.out.println(i + ", " + j);
        return i == j;
    }

    public static void main(String[] args) {
        SwapAdjacentInLRString s = new SwapAdjacentInLRString();
        System.out.println(s.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    }
}