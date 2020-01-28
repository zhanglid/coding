package com.zhangliang.google;
/*
已知screen的高和宽，给你最小和最大的fontSize，要求给定一个string，将string用尽可能大的 fontSize
显示在screen里。字符串如果是句子的话，单词不能被截断，要分配到下一行。 已知两个API getHeight(int fontSize),
 getWidth(char c, int fontSize)，可以得到每个character在不 同fontSize下的高和宽。 和面试官交流后，确认
 string可以拆分成几行显示在screen中，先提出暴力解法，然后用二分法优 化。
可以将屏幕按照font的宽高换算成有多少rows * cols，然后用418. Sentence Screen Fitting的思路 判断是否能装
下一个字符串或者句子。 上面这个作为binary search的条件，最终锁定满足条件的最大字体。(应该是返回right index
*/

public class LargestFontSize {
    private int getWidth(char c, int fontSize) {
        return 0;
    }

    // assume each char has the same height
    private int getHeight(int fontSize) {
        return 0;
    }

    public int solve(String s, int minFontSize, int maxFontSize, int screenHeight, int screenWidth) {
        if (s == null || s.length() < 1) {
            return maxFontSize;
        }

        s = s.trim();
        if (s.contains(" ")) {
            return sovleStringFix(s, minFontSize, maxFontSize, screenHeight, screenWidth);
        }
        return solveSentenceFix(s.split(" "), minFontSize, maxFontSize, screenHeight, screenWidth);
    }

    private int solveSentenceFix(String[] words, int minFontSize, int maxFontSize, int screenHeight, int screenWidth) {
        int min = minFontSize;
        int max = maxFontSize;

        while (min < max - 1) {
            int mid = min + (max - min) / 2;
            if (canSentenceFit(words, mid, screenHeight, screenWidth)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        if (canSentenceFit(words, max, screenHeight, screenWidth)) {
            return max;
        }

        return min;
    }

    private int sovleStringFix(String s, int minFontSize, int maxFontSize, int screenHeight, int screenWidth) {
        int min = minFontSize;
        int max = maxFontSize;

        while (min < max - 1) {
            int mid = min + (max - min) / 2;
            if (canStringFit(s, mid, screenHeight, screenWidth)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        if (canStringFit(s, max, screenHeight, screenWidth)) {
            return max;
        }

        return min;
    }

    private boolean canStringFit(String s, int fontSize, int screenHeight, int screenWidth) {
        int rowNum = screenHeight / getHeight(fontSize);
        int i = 0;
        int row = 0;
        for (; i < s.length() && row < rowNum; row++) {
            int col = 0;
            while (i < s.length() && col + getWidth(s.charAt(i), fontSize) <= screenHeight) {
                col += getWidth(s.charAt(i), fontSize);
                i++;
            }
        }

        return i == s.length();
    }

    private int getWordWidth(String word, int fontSize) {
        int count = 0;
        for (char c : word.toCharArray()) {
            count += getWidth(c, fontSize);
        }

        return count;
    }

    private boolean canSentenceFit(String[] words, int fontSize, int screenHeight, int screenWidth) {
        int rowNum = screenHeight / getHeight(fontSize);
        int i = 0;
        for (int row = 0; row < rowNum; row++) {
            int col = 0;
            while (i < words.length && col + getWordWidth(words[i], fontSize) <= screenWidth) {
                col += getWordWidth(words[i], fontSize) + getWidth(' ', fontSize);
                i++;
            }
            row++;
        }

        return i == words.length;
    }
}
