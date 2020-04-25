/*
输入数组 endorsements： 输入格式是 
```
[
    { skill: "javascript", user: "user1" },
    { skill: "css", user: "user2" },
    { skill: "html", user: "user3" },
    { skill: "javascript", user: "user2" },
    { skill: "css", user: "user3" },
    { skill: "javascript", user: "user3" }
]
```

输出: 
```
[
    { skill: "javascript", users: ["user1", "user2", "user3"], count: 3 },
    { skill: "css", users: ["user2", "user3"], count: 2 },
    { skill: "html", users: ["user3"], count: 1 }
]
```

follow up 输出需要按照 count 排序 用了一个 map 把 skill 作为 key，遍历 endorsements 数组处理，然后用 Object.values(map)输出结果
*/

export function getUsersBySkill(endorsements = []) {
    return Object.entries(
        endorsements.reduce(
            (result, { skill, user }) => ({
                ...result,
                [skill]: [...(result[skill] || []), user]
            }),
            {}
        )
    ).map(([skill, users]) => ({ skill, users, count: users.length }));
}
