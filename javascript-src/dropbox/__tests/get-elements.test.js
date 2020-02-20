import { JSDOM } from "jsdom";
import {
    getElementsByClassName,
    getElementsByHierarchy
} from "../get-elements";

describe("get-elements", () => {
    const getDom = html => new JSDOM(html).window.document;
    describe("getElementsByClassName", () => {
        test("testCase1", () => {
            const ele = getDom(
                `<div><div class="a">target</div><div>other</div></div>`
            );
            const result = getElementsByClassName(ele, "a");
            expect(result).toMatchInlineSnapshot(`
              Array [
                <div
                  class="a"
                >
                  target
                </div>,
              ]
          `);
        });

        test("testCase2", () => {
            const ele = getDom(
                `<div><div class="a">target1<div class="a">target2</div></div></div>`
            );
            const result = getElementsByClassName(ele, "a");
            expect(result).toMatchInlineSnapshot(`
Array [
  <div
    class="a"
  >
    target1
    <div
      class="a"
    >
      target2
    </div>
  </div>,
  <div
    class="a"
  >
    target2
  </div>,
]
`);
        });
    });

    describe("getElementsByHierarchy", () => {
        test("testCase1", () => {
            const ele = getDom(
                `<div><div class="a"><div class="b">target</div></div></div>`
            );
            const result = getElementsByHierarchy(ele, "a > b");
            expect(result).toMatchInlineSnapshot(`
Array [
  <div
    class="b"
  >
    target
  </div>,
]
`);
        });
    });
});
