import { numberToWords } from "../273.integer-to-english-words";

describe("273.integer-to-english-words", () => {
    test("testCase1", () => {
        expect(numberToWords(123)).toEqual("One Hundred Twenty Three");
    });
    test("testCase2", () => {
        expect(numberToWords(12345)).toEqual(
            "Twelve Thousand Three Hundred Forty Five"
        );
    });

    test("testCase3", () => {
        expect(numberToWords(1234567)).toEqual(
            "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        );
    });
});
