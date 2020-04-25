import { twoSum } from "../1.two-sum";

describe("1.two-sum", () => {
    test("testCase1", () => {
        expect(twoSum([2, 7, 11, 15], 9)).toEqual([0, 1]);
    });

    test("errCase1", () => {
        expect(twoSum([3, 2, 4], 6)).toEqual([1, 2]);
    });
});
