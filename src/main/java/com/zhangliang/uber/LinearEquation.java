package com.zhangliang.uber;
/*
第三轮。国人大哥。算法轮，给你一个二元一次方程：'2x - ((x - (3x + 1) + 2) + 3) + 4 = x + y' 然后给你x的值， 让你解出y的值。输入就是一个string和一个integer。输出是一个integer，很刺激吧。是不是感觉有点难，没关系，我把我的解法share给你们，如果还看不懂的话，那真的说明得下来好好下功夫刷题了
*/

public class LinearEquation {
    class CountType {
        int XCount;
        int YCount;
        int known;
    }

    class RtnType {
        CountType countResult;
        int end;
    }

    private RtnType normalize(String part, int start) {
        CountType countResult = new CountType();
        int end = part.length() - 1;
        boolean postive = true;
        int num = -1;

        for (int i = start; i < part.length(); i++) {
            if (part.charAt(i) == ' ') {
                continue;
            } else if (part.charAt(i) == ')') {
                end = i;
                break;
            } else if (part.charAt(i) == '(') {
                RtnType next = normalize(part, i + 1);
                countResult.XCount += (postive ? 1 : -1) * next.countResult.XCount;
                countResult.YCount += (postive ? 1 : -1) * next.countResult.YCount;
                countResult.known += (postive ? 1 : -1) * next.countResult.known;
                i = next.end;
                postive = true;
                num = -1;
            } else if (part.charAt(i) == 'y') {
                countResult.YCount += (postive ? 1 : -1) * Math.abs(num);
                postive = true;
                num = -1;
            } else if (part.charAt(i) == 'x') {
                countResult.XCount += (postive ? 1 : -1) * Math.abs(num);
                postive = true;
                num = -1;
            } else if (part.charAt(i) == '-') {
                if (num != -1) {
                    countResult.known += (postive ? 1 : -1) * Math.abs(num);
                }
                num = -1;
                postive = false;
            } else if (part.charAt(i) == '+') {
                if (num != -1) {
                    countResult.known += (postive ? 1 : -1) * Math.abs(num);
                }
                num = -1;
                postive = true;
            } else {
                num = (num == -1 ? 0 : num * 10) + (part.charAt(i) - '0');
            }
        }

        if (num != -1) {
            countResult.known += (postive ? 1 : -1) * Math.abs(num);
        }
        RtnType resultRtn = new RtnType();
        resultRtn.end = end;
        resultRtn.countResult = countResult;
        return resultRtn;
    }

    public int solve(String eqn, int x) {
        String[] parts = eqn.split("=");
        CountType left = normalize(parts[0], 0).countResult;
        CountType right = normalize(parts[1], 0).countResult;
        return (left.known - right.known + x * (left.XCount - right.XCount)) / (right.YCount - left.YCount);
    }
}
