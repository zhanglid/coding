import { getMaximumSubarray } from "../maximum-subarray.js";

describe("maximum-subarray", () => {
    test("testCase1", () => {
        expect(getMaximumSubarray([0, -1, 3, 4, -5, 0])).toEqual({
            result: 7,
            indexes: [2, 3]
        });
    });
});
