package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EvalExpressionTest {

    @Test
    public void testCase() {
        EvalExpression s = new EvalExpression();
        int ans = s.eval("123");
        assertEquals(123, ans);
    }

    @Test
    public void testCase2() {
        EvalExpression s = new EvalExpression();
        int ans = s.eval("<+ 1 2 3>");
        assertEquals(6, ans);
    }

    @Test
    public void testCase3() {
        EvalExpression s = new EvalExpression();
        int ans = s.eval("<*>");
        assertEquals(1, ans);
    }

    @Test
    public void testCase4() {
        EvalExpression s = new EvalExpression();
        int ans = s.eval("<+>");
        assertEquals(0, ans);
    }

    @Test
    public void testCase5() {
        EvalExpression s = new EvalExpression();
        int ans = s.eval("<+ 1 <* 3>>");
        assertEquals(4, ans);
    }
}
