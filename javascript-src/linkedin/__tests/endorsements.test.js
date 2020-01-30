import { getUsersBySkill } from "../endorsements";

describe("endorsements", () => {
    test("testCase1", () => {
        const endorsements = [
            { skill: "javascript", user: "user1" },
            { skill: "css", user: "user2" },
            { skill: "html", user: "user3" },
            { skill: "javascript", user: "user2" },
            { skill: "css", user: "user3" },
            { skill: "javascript", user: "user3" }
        ];

        const expected = [
            {
                skill: "javascript",
                users: ["user1", "user2", "user3"],
                count: 3
            },
            { skill: "css", users: ["user2", "user3"], count: 2 },
            { skill: "html", users: ["user3"], count: 1 }
        ];

        expect(getUsersBySkill(endorsements)).toEqual(expected);
    });
});
