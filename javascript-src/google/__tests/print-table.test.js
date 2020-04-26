import { printTable } from "../print-table.js";

describe("print-table", () => {
  test("testCase1", () => {
    expect(printTable(3, 4)).toEqual([
      [1, 6, 7, 12],
      [2, 5, 8, 11],
      [3, 4, 9, 10],
    ]);
  });
});
