package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BasicCalculatorIIITest {

    @Test
    public void testCase() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate("1 + 1");
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate(" 6-4 / 2 ");
        assertEquals(4, ans);
    }

    @Test
    public void testCase3() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate("2*(5+5*2)/3+(6/2+8)");
        assertEquals(21, ans);
    }

    @Test
    public void testCase4() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate("(2+6* 3+5- (3*14/7+2)*5)+3");
        assertEquals(-12, ans);
    }

    @Test
    public void errorCase() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate("0-2147483648");
        assertEquals(-2147483648, ans);
    }

    @Test
    public void errorCase2() {
        BasicCalculatorIII s = new BasicCalculatorIII();
        int ans = s.calculate(
                "(( (   (  ( ((( (  (3  -  18 )+ 8 )  -20 )+   (((   3 +18)   / (1+5   )   ) +(  (  12 *  12   )  +  (15-  10  )))   )   *  ( (   (  (  20  +   6   ) +  (  19  - 8) )+(  (   19+ 5  )  +  (  13   -   13  )   )  )  /   (( (6 +20 )   +  (9  +  19 )  )   +  (( 11  -  12)   -(  1   +  2  ) ) )   ))  -(   (   (  (   (  4  +   18 )   + (   8 -   8   )) *  (   (17  / 19  )  + (   1*   18)  ) )   +  ( ( ( 13  +   1 )   +   (8 + 10   )   )   + 9   )   )   +   (  (  (  (  1  +15)   +   (  9/ 15   ) ) *   ((  13  - 4  ) + (  13   +  4 ) )) +(  ((16 *  20   )   /  (5   +10   )  )+ ( (  15 *   16 )  *  (  2 -  4)   ))   )  ))+ ((8+ ( (  9  *  (  (  2   +  10)  + (  5  *   13)) )  +  (   (  (   16 +  4 )   -(   10  + 9  )) +  (( 19+   3 )   -   (  2 -  15   ))  )  )   )  /  (  12  /  5) )   ) +   ( (((   ( 3 +(   (   7+19  )   *   (   15   +   1  ) ))  *(  ((   5  *   8  )   /  (3 +3  ))   +  (  (  8 +7)  +  (  17+14  ) )) ) +   (  10 +   (  ( ( 8 /13)+   (   6+17   )   )+((   16 *  3   )  - ( 9 /   11 )  )  ))  )   -(( ( ((3   +   2   )   /(1+9   )  ) *   (   ( 13  +   18 )+ (17  * 14   )) )   +( (  ( 18 +  8   )*   (  20* 7 )  )   /  14   ))+ ( ((   ( 1   -   2)+(19  +   14   )  )  -  (   (   10 *9   )  *   (   19*  11))   )   -   ((   (17  -  9   )   +(5   * 2   )  )+20))  ))+9  )  )   +18   ) * 19)");
        assertEquals(770469, ans);
    }

}
