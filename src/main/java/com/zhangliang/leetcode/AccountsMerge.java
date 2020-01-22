package com.zhangliang.leetcode;
/*
Given a list accounts, each element accounts[i] is a list of strings, 
where the first element accounts[i][0] is a name, and the rest of the 
elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely 
belong to the same person if there is some email that is common to both 
accounts. Note that even if two accounts have the same name, they may 
belong to different people as people could have the same name. A person 
can have any number of accounts initially, but all of their accounts 
definitely have the same name.

After merging the accounts, return the accounts in the following format: 
the first element of each account is the name, and the rest of the 
elements are emails in sorted order. The accounts themselves can be 
returned in any order.

Example 1:
Input: 
accounts = [
    ["John", "johnsmith@mail.com", "john00@mail.com"], 
    ["John", "johnnybravo@mail.com"], 
    ["John", "johnsmith@mail.com", "john_newyork@mail.com"], 
    ["Mary", "mary@mail.com"]
]
Output: [
    [
        "John", 
        "john00@mail.com", 
        "john_newyork@mail.com", 
        "johnsmith@mail.com"
    ],  
    ["John", "johnnybravo@mail.com"], 
    ["Mary", "mary@mail.com"]
]
Explanation: 
The first and third John's are the same person as they have the common 
email "johnsmith@mail.com".
The second John and Mary are different people as none of their email 
addresses are used by other accounts.
We could return these lists in any order, for example the answer 
[
    ["Mary", "mary@mail.com"], 
    ["John", "johnnybravo@mail.com"], 
    [
        "John", 
        "john00@mail.com", 
        "john_newyork@mail.com", 
        "johnsmith@mail.com"
    ]
] would still be accepted.

Note:

The length of accounts will be in the range [1, 1000].
The length of accounts[i] will be in the range [1, 10].
The length of accounts[i][j] will be in the range [1, 30].
*/

import java.util.*;

public class AccountsMerge {
    // Run DFS from a point to find connect component, add add it to path.
    private void dfs(String point, Set<String> path, Map<String, Set<String>> graph) {
        if (path.contains(point)) {
            return;
        }
        path.add(point);
        for (String other : graph.get(point)) {
            dfs(other, path, graph);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Build graph.
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> emailNameMap = new HashMap<>();
        for (List<String> accountInfoList : accounts) {
            String name = accountInfoList.get(0);
            String firstEmail = accountInfoList.get(1);
            emailNameMap.put(firstEmail, name);
            if (!graph.containsKey(firstEmail)) {
                graph.put(firstEmail, new HashSet<>());
            }
            for (int i = 2; i < accountInfoList.size(); i++) {
                String email = accountInfoList.get(i);
                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
                emailNameMap.put(email, name);
            }
        }

        // Run dfs to get each connected component.
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String email : emailNameMap.keySet()) {
            if (!visited.contains(email)) {
                Set<String> path = new HashSet<>();
                dfs(email, path, graph);
                List<String> mergedAccountInfoList = new ArrayList<>();
                mergedAccountInfoList.add(emailNameMap.get(email));
                List<String> emailList = new ArrayList<>(path);
                Collections.sort(emailList);
                mergedAccountInfoList.addAll(emailList);
                result.add(mergedAccountInfoList);
                visited.addAll(path);
            }
        }
        return result;
    }
}
