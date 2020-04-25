import { calculate } from "../224.basic-calculator.js";

describe("224.basic-calculator test case", () => {
    test("testCase1", () => {
        expect(calculate("1 + 1")).toEqual(2);
    });

    test("testCase2", () => {
        expect(calculate(" 2-1 + 2 ")).toEqual(3);
    });

    test("testCase3", () => {
        expect(calculate("(1+(4+5+2)-3)+(6+8)")).toEqual(23);
    });
});
