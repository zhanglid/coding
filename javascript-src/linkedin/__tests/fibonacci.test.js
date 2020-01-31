import { fibonacci } from "../fibonacci";

describe("fibonacci", () => {
    test("testCase1", () => {
        expect(fibonacci(7)).toEqual([1, 1, 2, 3, 5, 8, 13]);
    });
});
