/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

/**
 * Evaluate the part that is a number.
 * @param {*} s  - Expression.
 * @param {*} startIndex  - The start index.
 */
function evalPart(s = "", startIndex = 0) {
    let value = 0,
        endIndex = s.length;

    for (let i = startIndex; i < s.length; i++) {
        const ch = s.charAt(i);
        if (ch >= "0" && ch <= "9") {
            value = 10 * value + (ch - "0");
        } else {
            endIndex = i;
            break;
        }
    }

    return [value, endIndex];
}

/**
 * Function to evaluate an expression connected with +/-.
 * @param {*} s - Expression to evaluate.
 * @param {*} startIndex - The start index.
 */
function evalSum(s = "", startIndex = 0) {
    let value = 0,
        endIndex = s.length,
        positive = true;

    for (let i = startIndex; i < s.length; i++) {
        const ch = s.charAt(i);
        if (ch === "(") {
            const [partValue, nextEndIndex] = evalSum(s, i + 1);
            value += positive ? partValue : -partValue;
            positive = true;
            i = nextEndIndex;
        } else if (ch === ")") {
            endIndex = i;
            break;
        } else if (ch === "-") {
            positive = false;
        } else if (ch >= "0" && ch <= "9") {
            const [partValue, nextEndIndex] = evalPart(s, i);
            value += positive ? partValue : -partValue;
            positive = true;
            i = nextEndIndex - 1;
        }
    }
    return [value, endIndex];
}

/**
 * @param {string} s
 * @return {number}
 */
export function calculate(s = "") {
    s = s.replace(" ", "");
    const [value] = evalSum(s);
    return value;
}
