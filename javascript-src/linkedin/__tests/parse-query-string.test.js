import { parse } from "../parse-query-string";

describe("parse-query-string", () => {
    test("testCase1", () => {
        expect(parse("http://example.com/over/there?name=ferret&id=1")).toEqual(
            {
                name: "ferret",
                id: "1"
            }
        );
    });

    test("testCase2", () => {
        expect(
            parse("http://example.com/over/there?name=ferret&name=tom&id=1")
        ).toEqual({ name: ["ferret", "tom"], id: "1" });
    });
});
