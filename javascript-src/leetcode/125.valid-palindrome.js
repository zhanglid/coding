/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/

/**
 * @param {string} s
 * @return {boolean}
 */
export const isPalindrome = s =>
    s
        .split("")
        .map(ch => ch.toLowerCase())
        .filter(
            ch => !!ch && ((ch >= "0" && ch <= "9") || (ch >= "a" && ch <= "z"))
        )
        .reduce(
            (result, ch, index, chs) =>
                result && ch === chs[chs.length - index - 1],
            true
        );
