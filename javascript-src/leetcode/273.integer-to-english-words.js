/*
Convert a non-negative integer to its english words 
representation. Given input is guaranteed to be less 
than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"

Example 2:

Input: 12345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:

Input: 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:

Input: 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five 
Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/
const DIGITS = [
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine"
];

const TEENS = [
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
];

const TENTH = [
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety"
];

// num: 0-9
function encodeDigit(num) {
    return DIGITS[num];
}

// num: 10-19
function encodeTeen(num) {
    return TEENS[num - 10];
}

// num: 20-99
function encodeTenth(num) {
    const tenth = Math.floor(num / 10) - 2;
    const digit = num % 10;
    return TENTH[tenth] + (digit === 0 ? "" : " " + encodeDigit(digit));
}

// num: 0-99
function encodeUnder100(num) {
    if (num >= 20) {
        return encodeTenth(num);
    } else if (num >= 10) {
        return encodeTeen(num);
    } else {
        return encodeDigit(num);
    }
}

const UNITS = [
    [1000000000, "Billion"],
    [1000000, "Million"],
    [1000, "Thousand"],
    [100, "Hundred"]
];

/**
 * @param {number} num
 * @return {string}
 */
export const numberToWords = num =>
    [
        ...UNITS.reduce(
            ([result, value], [base, unit]) => [
                [
                    ...result,
                    ...(value >= base
                        ? [numberToWords(Math.floor(value / base)), unit]
                        : [])
                ],
                value % base
            ],
            [[], num]
        )[0],
        num % 100 === 0 ? "" : encodeUnder100(num % 100)
    ]
        .filter(part => part)
        .join(" ") || encodeDigit(0);
