package com.zhangliang.google;
/*
王位继承，长子及其后代有优先级继承权，其次是次子及其后代，以此类推。完成以下几个API
- void birth(String parent, String name) // 父亲名字和孩子名字，生个娃 
- void death(String name // 此人要死
- List<String> getOrderOfSuccession() // 返回当前的继承顺序，死人不能出现

三个function会被反复调用，实现function细节。 HashMap + DFS
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuccessionThrone {
    class Node {
        boolean isDead;
        String name;
        List<Node> children;

        public Node(String name) {
            children = new ArrayList<>();
            this.name = name;
        }
    }

    Node king;
    Map<String, Node> nodes;

    public SuccessionThrone(String kingName) {
        king = new Node(kingName);
        nodes = new HashMap<>();
        nodes.put(kingName, king);
    }

    public void birth(String parent, String name) {
        if (!nodes.containsKey(parent)) {
            return;
        }
        Node node = new Node(name);
        nodes.put(name, node);
        Node parentNode = nodes.get(parent);
        parentNode.children.add(node);
    }

    public void die(String name) {
        if (!nodes.containsKey(name)) {
            return;
        }

        Node node = nodes.get(name);
        node.isDead = true;
    }

    private void dfs(Node root, List<String> order) {
        if (root == null) {
            return;
        }
        if (!root.isDead) {
            order.add(root.name);
        }
        for (Node node : root.children) {
            dfs(node, order);
        }
    }

    public List<String> getOrderOfSuccession() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }
}
