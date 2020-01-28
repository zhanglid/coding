package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.zhangliang.google.ChooseRandomPointUniformlyInRectangles.Reactangle;

import org.junit.Test;

public class ChooseRandomPointUniformlyInRectanglesTest {

    @Test
    public void testCase() {
        ChooseRandomPointUniformlyInRectangles s = new ChooseRandomPointUniformlyInRectangles();
        List<Reactangle> list = new ArrayList<>();
        Reactangle rect = new Reactangle(new int[] { 0, 10 }, new int[] { 10, 20 });
        list.add(rect);
        int[] ans = s.choosePointWithoutOverlap(list);
        assertTrue(ans[0] < rect.rightTop[0] && ans[1] < rect.rightTop[1] && ans[0] > rect.leftDown[0]
                && ans[1] >= rect.leftDown[1]);
    }
}
