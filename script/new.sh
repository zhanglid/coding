#!/bin/bash

if [ "$1" = '' ]
then
    read -p "Enter problem name: " PROBLEM_NAME
else
    PROBLEM_NAME=$1
fi

CLASS_FILE_PATH="src/main/java/com/zhangliang/leetcode/${PROBLEM_NAME}.java"
TEST_FILE_PATH="src/test/java/com/zhangliang/leetcode/${PROBLEM_NAME}Test.java"

echo $CLASS_FILE_PATH
echo $TEST_FILE_PATH

touch $CLASS_FILE_PATH
touch $TEST_FILE_PATH

echo 'package com.zhangliang.leetcode;' >> $CLASS_FILE_PATH
echo '/*' >> $CLASS_FILE_PATH
echo '*/' >> $CLASS_FILE_PATH
echo '' >> $CLASS_FILE_PATH
echo "public class $PROBLEM_NAME {" >> $CLASS_FILE_PATH
echo '    public int solve() {' >> $CLASS_FILE_PATH
echo '        ' >> $CLASS_FILE_PATH
echo '    }' >> $CLASS_FILE_PATH
echo '' >> $CLASS_FILE_PATH
echo '    public static void main(String[] args) {' >> $CLASS_FILE_PATH
echo "        $PROBLEM_NAME s = new $PROBLEM_NAME();" >> $CLASS_FILE_PATH
echo '        System.out.println(s.solve());' >> $CLASS_FILE_PATH
echo '    }' >> $CLASS_FILE_PATH
echo '}' >> $CLASS_FILE_PATH


echo 'package com.zhangliang.leetcode;' >> $TEST_FILE_PATH
echo 'import static org.junit.Assert.assertEquals;' >> $TEST_FILE_PATH
echo 'import java.util.Arrays;' >> $TEST_FILE_PATH
echo 'import org.junit.Test;' >> $TEST_FILE_PATH
echo '' >> $TEST_FILE_PATH
echo "public class ${PROBLEM_NAME}Test{" >> $TEST_FILE_PATH
echo '' >> $TEST_FILE_PATH
echo '@Test' >> $TEST_FILE_PATH
echo 'public void testCase() {' >> $TEST_FILE_PATH
echo "    ${PROBLEM_NAME} s = new ${PROBLEM_NAME}();" >> $TEST_FILE_PATH
echo '    String ans = s.solve();' >> $TEST_FILE_PATH
echo '    assertEquals(ans, "");' >> $TEST_FILE_PATH
echo '}' >> $TEST_FILE_PATH
echo '}' >> $TEST_FILE_PATH