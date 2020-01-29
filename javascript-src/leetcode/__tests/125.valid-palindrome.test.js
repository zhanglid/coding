import { isPalindrome } from "../125.valid-palindrome";

describe("125.valid-palindrome", () => {
    test("testCase1", () => {
        expect(isPalindrome("A man, a plan, a canal: Panama")).toEqual(true);
    });
    test("testCase2", () => {
        expect(isPalindrome("race a car")).toEqual(false);
    });
});
