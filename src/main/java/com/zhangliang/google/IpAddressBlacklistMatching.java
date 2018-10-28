package com.zhangliang.google;
/*
给一个black list，里面都是ip address，ip address里可能包含wildcard字符 "*", 
问如果现在有一 个ip address，它是否在black list里。和面试官交流后，确认ip address
都是合法的，而wildcard 只会出现每个地址的最后，直接用trie做了。
*/

public class IpAddressBlacklistMatching {
    class Tire {
        class Node {
            Node[] nodes;
            boolean hasNode;

            public Node() {
                nodes = new Node[256];
            }
        }

        Node head;

        public Tire() {
            head = new Node();
        }

        public void insert(int[] ip) {
            Node cur = head;
            for (int var : ip) {
                if (var == -1) {
                    break;
                }
                if (cur.nodes[var] == null) {
                    cur.nodes[var] = new Node();
                }
                cur = cur.nodes[var];
            }
            cur.hasNode = true;
        }

        public boolean hasPrefix(int[] ip) {
            Node cur = head;
            for (int part : ip) {
                if (cur.nodes[part] == null) {
                    return false;
                }
                if (cur.nodes[part].hasNode) {
                    return true;
                }
                cur = cur.nodes[part];
            }

            return cur.hasNode;
        }
    }

    private int[] toParts(String ip) {
        String[] ips = ip.split("\\.");
        int[] result = new int[ips.length];

        for (int i = 0; i < result.length; i++) {
            if (ips[i].equals("*")) {
                result[i] = -1;
                continue;
            }
            result[i] = Integer.parseInt(ips[i]);
        }

        return result;
    }

    public boolean solve(String ip, String target) {
        if (ip == null || target == null) {
            return false;
        }

        int[] targetParts = toParts(target);
        int[] parts = toParts(ip);
        Tire tire = new Tire();

        tire.insert(targetParts);

        return tire.hasPrefix(parts);
    }
}
